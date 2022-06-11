package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.MallaCarreraException;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.CarreraRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.MallaCarreraRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;

@Service
public class CarreraService {

    private CarreraRepository carreraRepository;
    private MallaCarreraRepository mallaCarreraRepository;

    public CarreraService(CarreraRepository carreraRepository, MallaCarreraRepository mallaCarreraRepository) {
        this.carreraRepository = carreraRepository;
        this.mallaCarreraRepository = mallaCarreraRepository;
    }

    public Carrera obtenerPorCodigo(Integer codigo) {
        Optional<Carrera> carreraOpt = this.carreraRepository.findById(codigo);
        if(carreraOpt.isPresent()) {
            return carreraOpt.get();
        } else {
            return null;
        }
    }

    public MallaCarrera obtenerMallaCarreraPorCodigo(Integer codigo) {
        Optional<MallaCarrera> mallaCarreraOpt = this.mallaCarreraRepository.findById(codigo);
        if(mallaCarreraOpt.isPresent()) {
            return mallaCarreraOpt.get();
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

    public List<MallaCarrera> obtenerMalla(Integer codigo) throws MallaCarreraException {
        Carrera carrera = this.obtenerPorCodigo(codigo);
        if(carrera == null) {
            throw new MallaCarreraException("No existe la Carrera para el código recibido.");
        }
        List<MallaCarrera> materiasMalla = this.mallaCarreraRepository.findByCodCarreraOrderByNivelAsc(codigo);
        if(materiasMalla.isEmpty()) {
            throw new MallaCarreraException("No existen materias en la malla de esta Carrera");
        } else {
            return materiasMalla;
        }
    }

    public List<MallaCarrera> obtenerMateriasPorNivel(Integer codCarrera, Integer nivel) throws MallaCarreraException {
        Carrera carrera = this.obtenerPorCodigo(codCarrera);
        if(carrera == null) {
            throw new MallaCarreraException("No existe la Carrera para el código recibido.");
        }
        List<MallaCarrera> materiasMalla = this.mallaCarreraRepository.findByCodCarreraAndNivel(codCarrera, nivel);
        if(materiasMalla.isEmpty()) {
            throw new MallaCarreraException("No existen materias en en el Nivel recibido.");
        } else {
            return materiasMalla;
        }
    }

    public void modificarMateriMallaCarrera(MallaCarrera materiaCarrera) {
        MallaCarrera materiaCarreraBD = this.obtenerMallaCarreraPorCodigo(materiaCarrera.getCodMateriaCarrera());
        materiaCarreraBD.setNivel(materiaCarrera.getNivel());
        this.mallaCarreraRepository.save(materiaCarreraBD);
    }
    
}
