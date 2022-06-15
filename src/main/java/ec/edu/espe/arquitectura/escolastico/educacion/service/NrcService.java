package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.NotFoundException;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcHorarioRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.PeriodoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MateriaPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import ec.edu.espe.arquitectura.escolastico.persona.dao.PersonaRepository;
import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;

@Service
public class NrcService {

    private NrcRepository nrcRepository;
    private NrcHorarioRepository nrcHorarioRepository;
    private PeriodoRepository periodoRepository;
    private PersonaRepository personaRepository;
    private MateriaRepository materiaRepository;
    

    public NrcService(NrcRepository nrcRepository, NrcHorarioRepository nrcHorarioRepository,
            PeriodoRepository periodoRepository, PersonaRepository personaRepository,
            MateriaRepository materiaRepository) {
        this.nrcRepository = nrcRepository;
        this.nrcHorarioRepository = nrcHorarioRepository;
        this.periodoRepository = periodoRepository;
        this.personaRepository = personaRepository;
        this.materiaRepository = materiaRepository;
    }

    public Nrc obtenerPorCodigo(NrcPK pk) {
        Optional<Nrc> nrcOpt = this.nrcRepository.findById(pk);
        if (nrcOpt.isPresent()) {
            return nrcOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Nrc nrc) {

        Optional<Periodo> periodoOpt = this.periodoRepository.findById(nrc.getPk().getCodPeriodo());
        if (!periodoOpt.isPresent()) {
            throw new NotFoundException("Periodo no encontrado");
        }

        MateriaPK pk = new MateriaPK(nrc.getPk().getCodMateria(), nrc.getPk().getCodDepartamento());
        Optional<Materia> materiaOpt = this.materiaRepository.findById(pk);
        if (!materiaOpt.isPresent()) {
            throw new NotFoundException("Materia no encontrada");
        }

        Optional<Persona> personaOpt = this.personaRepository.findById(nrc.getCodDocente());
        if (!personaOpt.isPresent()) {
            throw new NotFoundException("Docente no encontrado");
        }
        
        this.nrcRepository.save(nrc);
        

    }

    public void modificar(Nrc nrc) {
        Nrc nrcBd = this.obtenerPorCodigo(nrc.getPk());
        nrcBd.setCodDocente(nrc.getCodDocente());
        nrcBd.setCupoDisponible(nrc.getCupoDisponible());
        nrcBd.setCupoRegistrado(nrc.getCupoRegistrado());
        nrcBd.setNombre(nrc.getNombre());
        this.nrcRepository.save(nrcBd);
    }

    public List<Nrc> listarNrcPorPeriodoYDocente(Integer codPeriodo, Integer codDocente) {
        return this.nrcRepository.findByPkCodPeriodoAndCodDocenteOrderByMateriaNombreAsc(codPeriodo, codDocente);
    }

    public List<Nrc> listarNrcPorPeriodoYDepartamento(Integer codPeriodo, Integer codDepartamento) {
        return this.nrcRepository.findByPkCodPeriodoAndPkCodDepartamentoOrderByMateriaNombreAsc(codPeriodo,
                codDepartamento);
    }

}
