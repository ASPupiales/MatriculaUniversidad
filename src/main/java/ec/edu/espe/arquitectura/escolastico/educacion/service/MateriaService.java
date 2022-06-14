package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.MateriaRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.PrerequisitoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MateriaPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Prerequisito;

@Service
public class MateriaService {

    private MateriaRepository materiaRepository;
    private PrerequisitoRepository prerequisitoRepository;

    public MateriaService(MateriaRepository materiaRepository, PrerequisitoRepository prerequisitoRepository) {
        this.materiaRepository = materiaRepository;
        this.prerequisitoRepository = prerequisitoRepository;
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
        Materia materiaBD = this.obtenerPorCodigo(materia.getPk());
        this.materiaRepository.save(materiaBD);
        this.prerequisitoRepository.saveAll(materia.getPrerequisitos());
    }

    public void modificar(Materia materia) {
        Materia materiaBD = this.obtenerPorCodigo(materia.getPk());
        materiaBD.setNombre(materia.getNombre());
        materiaBD.setCreditos(materia.getCreditos());
        materiaBD.setHoras(materia.getHoras());
        materiaBD.setPonderacion(materia.getPonderacion());
        List<Prerequisito> prerequisitosOpt = this.prerequisitoRepository.findByCodMateria(materia.getPk().getCodMateria());
        if(!prerequisitosOpt.isEmpty()) {
            this.prerequisitoRepository.deleteAll(prerequisitosOpt);
        }
        this.prerequisitoRepository.saveAll(materia.getPrerequisitos());
    }

    public List<Materia> listarMateriasPorDepartamento(Integer codDepartamento) {
        return this.materiaRepository.findByPkCodDepartamentoOrderByNombreAsc(codDepartamento);
    }

    public List<Materia> listarMateriasPorNombre(String nombrePattern) {
        return this.materiaRepository.findByNombreLikeOrderByNombreAsc(nombrePattern);
    }
    
}
