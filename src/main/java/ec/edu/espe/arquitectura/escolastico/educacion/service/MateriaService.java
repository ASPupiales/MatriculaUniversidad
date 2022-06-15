package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.DepartamentoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.PrerequisitoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MateriaPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Prerequisito;

@Service
public class MateriaService {

    private MateriaRepository materiaRepository;
    private PrerequisitoRepository prerequisitoRepository;
    private DepartamentoRepository departamentoRepository;

    public MateriaService(MateriaRepository materiaRepository, PrerequisitoRepository prerequisitoRepository,
            DepartamentoRepository departamentoRepository) {
        this.materiaRepository = materiaRepository;
        this.prerequisitoRepository = prerequisitoRepository;
        this.departamentoRepository = departamentoRepository;
    }

    public Materia obtenerPorCodigo(MateriaPK codigo) {
        Optional<Materia> materiaOpt = this.materiaRepository.findById(codigo);
        if(materiaOpt.isPresent()) {
            return materiaOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Materia materia) {
        Optional<Departamento> departamentoOpt = this.departamentoRepository.findById(materia.getPk().getCodDepartamento());
        List<Prerequisito> prerequisitosList = new ArrayList<>();
        if(!departamentoOpt.isPresent()) {
            throw new EntityNotFoundException("No se encontró el Departamento.");
        }
        for(Prerequisito prerequisito: materia.getPrerequisitos()) {
            MateriaPK pk = new MateriaPK(prerequisito.getPrerequisito().getPk().getCodMateria(), prerequisito.getPrerequisito().getPk().getCodDepartamento());
            Optional<Materia> prerequisitoOpt = this.materiaRepository.findById(pk);
            if(!prerequisitoOpt.isPresent()) {
                throw new EntityNotFoundException("No se encontró el Prerequisito.");
            }
            prerequisito.setPrerequisito(prerequisitoOpt.get());
            prerequisito.setMateria(materia);
            prerequisitosList.add(prerequisito);
        }
        materia.setDepartamento(departamentoOpt.get());
        this.materiaRepository.save(materia);
        this.prerequisitoRepository.saveAll(prerequisitosList);
    }

    public void modificar(Materia materia) {
        Materia materiaBD = this.obtenerPorCodigo(materia.getPk());
        materiaBD.setNombre(materia.getNombre());
        materiaBD.setCreditos(materia.getCreditos());
        materiaBD.setHoras(materia.getHoras());
        materiaBD.setPonderacion(materia.getPonderacion());
        List<Prerequisito> prerequisitosOpt = this.prerequisitoRepository.findByCodMateria(materia.getPk().getCodMateria());
        List<Prerequisito> prerequisitosList = new ArrayList<>();
        if(!prerequisitosOpt.isEmpty()) {
            this.prerequisitoRepository.deleteAll(prerequisitosOpt);
        }
        for(Prerequisito prerequisito: materia.getPrerequisitos()) {
            MateriaPK pk = new MateriaPK(prerequisito.getPrerequisito().getPk().getCodMateria(), prerequisito.getPrerequisito().getPk().getCodDepartamento());
            Optional<Materia> prerequisitoOpt = this.materiaRepository.findById(pk);
            if(!prerequisitoOpt.isPresent()) {
                throw new EntityNotFoundException("No se encontró el Prerequisito.");
            }
            prerequisito.setPrerequisito(prerequisitoOpt.get());
            prerequisito.setMateria(materia);
            prerequisitosList.add(prerequisito);
        }
        this.materiaRepository.save(materiaBD);
        this.prerequisitoRepository.saveAll(prerequisitosList);
    }

    public List<Materia> listarMateriasPorDepartamento(Integer codDepartamento) {
        return this.materiaRepository.findByPkCodDepartamentoOrderByNombreAsc(codDepartamento);
    }

    public List<Materia> listarMateriasPorNombre(String nombrePattern) {
        return this.materiaRepository.findByNombreContainingIgnoreCaseOrderByNombreAsc(nombrePattern);
    }
    
}
