package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.CarreraRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;

@Service
public class CarreraService {

    private CarreraRepository carreraRepository;

    public CarreraService(CarreraRepository carreraRepository) {
        this.carreraRepository = carreraRepository;
    }

    public Carrera obtenerPorCodigo(Integer codigo) {
        Optional<Carrera> carreraOpt = this.carreraRepository.findById(codigo);
        if(carreraOpt.isPresent()) {
            return carreraOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Carrera carrera) {
        this.carreraRepository.save(carrera);
    }

    public void modificar(Carrera carrera) {
        Carrera carreraBD = this.obtenerPorCodigo(carrera.getCodCarrera());
        carreraBD.setNombre(carrera.getNombre());
        carreraBD.setTotalSemestres(carrera.getTotalSemestres());
        carreraBD.setGrado(carrera.getGrado());
        carreraBD.setPerfilProfesional(carrera.getPerfilProfesional());
        carreraBD.setNivel(carrera.getNivel());
        carreraBD.setTotalCreditos(carrera.getTotalCreditos());
        carreraBD.setTotalHoras(carrera.getTotalHoras());
        carreraBD.setSiglas(carrera.getSiglas());
        carreraBD.setPrecioCredito(carrera.getPrecioCredito());
        carreraBD.setModalidad(carrera.getModalidad());
        this.carreraRepository.save(carreraBD);
    }

    public Carrera obtenerPorSiglas(String siglas) {
        return this.carreraRepository.findBySiglas(siglas);
    }

    public List<Carrera> listarCarrerasPorDepartamento(Integer codDepartamento) {
        return this.carreraRepository.findByCodDepartamentoOrderByNombreAsc(codDepartamento);
    }

    public List<Carrera> listarCarrerasPorNombre(String nombrePattern) {
        return this.carreraRepository.findByNombreLikeOrderByNombreAsc(nombrePattern);
    }
    
}
