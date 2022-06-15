package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import ec.edu.espe.arquitectura.escolastico.seguridad.RegistroSesionEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.RegistroSesionRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.RegistroSesion;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroSesionService {

    private RegistroSesionRepository registroSesionRepository;
    private UsuarioRepository usuarioRepository;

    public RegistroSesionService(RegistroSesionRepository registroSesionRepository, UsuarioRepository usuarioRepository) {
        this.registroSesionRepository = registroSesionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<RegistroSesion> listarPorCodigoUsuarioYFechaConexion(String codUsuario, Date fechaConexion){
        return this.registroSesionRepository.findByCodUsuarioAndFechaConexionGreaterThan(codUsuario,fechaConexion);
    }

    public List<RegistroSesion> listarPorCodigoUsuarioYResultadoYFechaConexion(String codUsuario,String resultado, Date fechaConexion){
        return this.registroSesionRepository.findByCodUsuarioAndResultadoAndFechaConexionGreaterThan(codUsuario,resultado,fechaConexion);
    }

    public RegistroSesion crear(RegistroSesion registroSesion) throws UnknownHostException {
        Optional<Usuario> usuarioOpt= this.usuarioRepository.findById(registroSesion.getCodUsuario());
        if (usuarioOpt.isPresent()){
            InetAddress address = InetAddress.getLocalHost();
            registroSesion.setIpConexion(address.getHostAddress());
            registroSesion.setFechaConexion(new Date());
            return this.registroSesionRepository.save(registroSesion);
        }else {
            return null;
        }
    }

}
