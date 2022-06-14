package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadoEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.FuncionalidadRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.ModuloRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilFuncionalidadRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Funcionalidad;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class FuncionalidadService {

    private FuncionalidadRepository funcionalidadRepository;
    private ModuloRepository moduloRepository;
    private PerfilFuncionalidadRepository perfilFuncionalidadRepository;

    public FuncionalidadService(FuncionalidadRepository funcionalidadRepository, ModuloRepository moduloRepository, PerfilFuncionalidadRepository perfilFuncionalidadRepository) {
        this.funcionalidadRepository = funcionalidadRepository;
        this.moduloRepository = moduloRepository;
        this.perfilFuncionalidadRepository = perfilFuncionalidadRepository;
    }

    public Funcionalidad buscarPorCodigo(Integer codigo) {
        Optional<Funcionalidad> funcionalidadOpt = this.funcionalidadRepository.findById(codigo);
        if (funcionalidadOpt.isPresent()) {
            return funcionalidadOpt.get();
        } else {
            return null;
        }
    }

    public List<Funcionalidad> buscarCodigoModulo(String codigo) {
        return this.funcionalidadRepository.findByCodModuloAndEstado(codigo, EstadoEnum.ACTIVO.getValor());
    }

    public Funcionalidad crear(Funcionalidad funcionalidad) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        funcionalidad.setAudIp(address.getHostAddress());
        funcionalidad.setAudFecha(new Date());
        funcionalidad.setAudUsuario("Admin");
        funcionalidad.setEstado(EstadoEnum.INACTIVO.getValor());
        this.funcionalidadRepository.save(funcionalidad);
        return funcionalidad;
    }

    public Funcionalidad modificar(Funcionalidad funcionalidad){
        Funcionalidad funcionalidadDB = this.buscarPorCodigo(funcionalidad.getCodFuncionalidad());
        funcionalidadDB.setEstado(funcionalidad.getEstado());
        funcionalidadDB.setNombre(funcionalidad.getNombre());
        funcionalidadDB.setDescripcion(funcionalidad.getDescripcion());
        funcionalidadDB.setUrlPrincipal(funcionalidad.getUrlPrincipal());
        return this.funcionalidadRepository.save(funcionalidadDB);
    }
}
