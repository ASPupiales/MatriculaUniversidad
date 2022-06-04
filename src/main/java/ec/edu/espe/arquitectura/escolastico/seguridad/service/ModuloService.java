package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadoEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.ModuloRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;

@Service
public class ModuloService {

    private ModuloRepository moduloRespository;

    public ModuloService(ModuloRepository moduloRespository) {
        this.moduloRespository = moduloRespository;
    }

    public void crear(Modulo modulo) {
        modulo.setEstado(EstadoEnum.INACTIVO.getValor());
        this.moduloRespository.save(modulo);
    }

    public void modificar(Modulo modulo) {
        this.moduloRespository.save(modulo);
    }

    public List<Modulo> listarModulosActivos() {
        return this.moduloRespository.findByEstado(EstadoEnum.ACTIVO.getValor());
    }

}
