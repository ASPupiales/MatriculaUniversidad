package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadoEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilFuncionalidadRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.PerfilRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.PerfilFuncionalidad;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PerfilService {

    private PerfilRepository perfilRepository;
    private PerfilFuncionalidadRepository perfilFuncionalidadRepository;

    public PerfilService(PerfilRepository perfilRepository, PerfilFuncionalidadRepository perfilFuncionalidadRepository) {
        this.perfilRepository = perfilRepository;
        this.perfilFuncionalidadRepository = perfilFuncionalidadRepository;
    }

    public List<Perfil> listarPerfilesPorEstado(String estado){
        return this.perfilRepository.findByEstado(estado);
    }
    public Perfil obtenerPorCodigo(String codigo){
        Optional<Perfil> perfilOpt = this.perfilRepository.findById(codigo);
        if (perfilOpt.isPresent()){
            return perfilOpt.get();
        }else{
            return null;
        }
    }

    public Perfil crear(Perfil perfil) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        perfil.setAudIp(address.getHostAddress());
        perfil.setAudFecha(new Date());
        perfil.setAudUsuario("Admin");
        perfil.setEstado(EstadoEnum.INACTIVO.getValor());
        this.perfilRepository.save(perfil);
        this.perfilFuncionalidadRepository.saveAll(perfil.getPerfilesFuncionalidad());
        return perfil;
    }

    public Perfil modificar(Perfil perfil){
        Perfil perfilDB = this.obtenerPorCodigo(perfil.getCodPerfil());
        perfilDB.setEstado(perfil.getEstado());
        perfilDB.setNombre(perfil.getNombre());
        return this.perfilRepository.save(perfilDB);
    }

}
