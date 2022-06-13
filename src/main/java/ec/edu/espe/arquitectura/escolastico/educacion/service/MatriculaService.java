package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.EstadoMatriculaNrcEnum;
import ec.edu.espe.arquitectura.escolastico.educacion.MatriculaException;
import ec.edu.espe.arquitectura.escolastico.educacion.NotFoundException;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MatriculaNrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MatriculaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrcPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;

@Service
public class MatriculaService {

    private MatriculaRepository matriculaRepository;
    private MatriculaNrcRepository matriculaNrcRepository;
    private PersonaRepository personaRepository;
    private NrcRepository nrcRepository;

    public MatriculaService(MatriculaRepository matriculaRepository, MatriculaNrcRepository matriculaNrcRepository,
            PersonaRepository personaRepository, NrcRepository nrcRepository) {
        this.matriculaRepository = matriculaRepository;
        this.matriculaNrcRepository = matriculaNrcRepository;
        this.personaRepository = personaRepository;
        this.nrcRepository = nrcRepository;
    }

    public Matricula obtenerPorPK(MatriculaPK pk) {
        Optional<Matricula> matriculaOpt = this.matriculaRepository.findById(pk);
        if (matriculaOpt.isPresent()) {
            return matriculaOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Matricula matricula) {
        Optional<Persona> personaOpt = this.personaRepository.findById(matricula.getPk().getCodAlumno());
        if (!personaOpt.isPresent()) {
            throw new NotFoundException("Alumno no encontrado");
        }
        matricula.setFecha(new Date());
        this.matriculaRepository.save(matricula);
        this.matriculaNrcRepository.saveAll(matricula.getMatriculaNrcs());
    }

    public void matricularse(Matricula matricula, List<Nrc> codNrcs) {
        Optional<Persona> personaOpt = this.personaRepository.findById(matricula.getPk().getCodAlumno());
        if (!personaOpt.isPresent()) {
            throw new NotFoundException("Alumno no encontrado");
        }
        matricula.setFecha(new Date());
        BigDecimal costoT = new BigDecimal(0);
        for (Nrc nrc : codNrcs) {
            Optional<Nrc> nrcOpt = this.nrcRepository.findById(nrc.getPk());
            if (!nrcOpt.isPresent()) {
                throw new NotFoundException("NRC no encontrado");
            }

            if (!matricula.getCodPeriodo().equals(nrc.getPk().getCodPeriodo())) {
                throw new MatriculaException("Los periodos no coinciden");
            }
            MatriculaNrc matriculaNrc = new MatriculaNrc();
            MatriculaNrcPK pk = new MatriculaNrcPK();
            pk.setCodMatricula(matricula.getPk().getCodMatricula());
            pk.setCodPersona(matricula.getPk().getCodAlumno());
            pk.setCodNrc(nrc.getPk().getCodNrc());
            pk.setCodPeriodo(matricula.getCodPeriodo());
            pk.setCodDepartamento(nrc.getPk().getCodDepartamento());
            pk.setCodMateria(nrc.getPk().getCodMateria());
            matriculaNrc.setPk(pk);
            matriculaNrc.setCosto(nrcOpt.get().getMateria().getHoras().multiply(new BigDecimal(15)));
            costoT = costoT.add(matriculaNrc.getCosto());
            List<MatriculaNrc> matriculasNrc = this.matriculaNrcRepository
                    .findByPkCodPersonaAndPkCodMateria(matricula.getPk().getCodAlumno(), nrc.getPk().getCodMateria());
            int repeticion = 0;
            boolean aprobado = false;
            for (MatriculaNrc matriculaNrc2 : matriculasNrc) {
                if (EstadoMatriculaNrcEnum.APROBADO.getValor().equals(matriculaNrc2.getEstado()) || EstadoMatriculaNrcEnum.PENDIENTE.getValor().equals(matriculaNrc2.getEstado())) {
                    aprobado = true;
                } else {
                    repeticion++;
                }
            }
            if(aprobado || repeticion > 3){
                throw new MatriculaException("No puede tomar esta materia");
            }
            matriculaNrc.setNumero(repeticion + 1);
            matriculaNrc.setEstado(EstadoMatriculaNrcEnum.PENDIENTE.getValor());
            if(nrcOpt.get().getCupoRegistrado().compareTo(nrcOpt.get().getCupoDisponible()) >= 0){
                throw new MatriculaException("No hay cupos disponibles");
            }
            nrcOpt.get().setCupoRegistrado(Integer.sum(nrcOpt.get().getCupoRegistrado(),1));

            matricula.getMatriculaNrcs().add(matriculaNrc);
        }
        matricula.setCosto(costoT);
        this.matriculaRepository.save(matricula);
        //this.matriculaNrcRepository.saveAll(matricula.getMatriculaNrcs());
    }

    public void modificar(Matricula matricula) {
        Matricula matriculaBD = this.obtenerPorPK(matricula.getPk());
        matriculaBD.setTipo(matricula.getTipo());
        matriculaBD.setFecha(matricula.getFecha());
        matriculaBD.setCosto(matricula.getCosto());
        this.matriculaRepository.save(matriculaBD);
        List<MatriculaNrc> matriculaNrcs = this.matriculaNrcRepository
                .findByPkCodMatriculaAndPkCodPersonaAndPkCodPeriodo(matricula.getPk().getCodMatricula(),
                        matricula.getPk().getCodAlumno(), matricula.getCodPeriodo());
        if (!matriculaNrcs.isEmpty()) {
            this.matriculaNrcRepository.deleteAll(matriculaNrcs);
        }
        this.matriculaNrcRepository.saveAll(matriculaBD.getMatriculaNrcs());
    }

    public Matricula obtenerPorPeriodoYEstudiante(Integer codPeriodo, Integer codEstudiante) {
        return this.matriculaRepository.findByCodPeriodoAndPkCodAlumno(codPeriodo, codEstudiante);
    }

    public List<Matricula> listarPorTipoYEstudiante(String tipo, Integer codEstudiante) {
        return this.matriculaRepository.findByTipoAndPkCodAlumnoOrderByFechaDesc(tipo, codEstudiante);
    }

    public List<Matricula> listarMatriculasPorAlumno(Integer codAlumno){
        return this.matriculaRepository.findByPkCodAlumnoOrderByFechaDesc(codAlumno);
    }

}
