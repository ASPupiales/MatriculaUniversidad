package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.DepartamentoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;

@Service
public class DepartamentoService {

    private DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public Departamento obtenerPorCodigo(Integer codigo) {
        Optional<Departamento> departamentoOpt = this.departamentoRepository.findById(codigo);
        if(departamentoOpt.isPresent()) {
            return departamentoOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Departamento departamento) {
        this.departamentoRepository.save(departamento);
    }

    public void modificar(Departamento departamento) {
        Departamento departamentoBD = this.obtenerPorCodigo(departamento.getCodDepartamento());
        departamentoBD.setSiglas(departamento.getSiglas());
        departamentoBD.setNombre(departamento.getNombre());
        departamentoBD.setDescripcion(departamento.getDescripcion());
        this.departamentoRepository.save(departamentoBD);
    }

    public Departamento obtenerPorSiglas(String siglas) {
        return this.departamentoRepository.findBySiglas(siglas);
    }

    public List<Departamento> listarDepartamentosPorNombre(String nombrePattern) {
        return  this.departamentoRepository.findByNombreLikeOrderByNombreAsc(nombrePattern);
    }

    public List<Departamento> listarDepartamentos() {
        return this.departamentoRepository.findAll();
    }
    
}
