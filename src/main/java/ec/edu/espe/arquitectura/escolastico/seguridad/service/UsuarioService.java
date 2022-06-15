package ec.edu.espe.arquitectura.escolastico.seguridad.service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioPerfilRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.dao.UsuarioRepository;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.CambioClaveException;
import ec.edu.espe.arquitectura.escolastico.seguridad.exception.InciarSesionException;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioPerfilRepository usuarioPerfilRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioPerfilRepository usuarioPerfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioPerfilRepository = usuarioPerfilRepository;
    }

    public Usuario buscarPorCodigo(String codigo) {
        Optional<Usuario> usuarioOpt = this.usuarioRepository.findById(codigo);
        if (usuarioOpt.isPresent()) {
            return usuarioOpt.get();
        } else {
            return null;
        }
    }

    public Usuario buscarPorMail(String mail) {
        return this.usuarioRepository.findByMail(mail);
    }

    public Usuario buscarPorCodigoOMail(String valor) {
        Usuario usuario = this.buscarPorCodigo(valor);
        if (usuario == null) {
            usuario = this.buscarPorMail(valor);
        }
        return usuario;
    }

    public List<Usuario> buscarPorNombre(String nombrePattern) {
        return this.usuarioRepository.findByNombreLikeOrderByNombre("%" + nombrePattern + "%");
    }

    public List<Usuario> buscarPorNombreYEstado(String nombrePattern, EstadoPersonaEnum estado) {
        return this.usuarioRepository.findByNombreLikeAndEstadoOrderByNombre(nombrePattern, estado.getValor());
    }

    public List<Usuario> buscarPorEstado(EstadoPersonaEnum estado) {
        return this.usuarioRepository.findByEstado(estado.getValor());
    }

    public Usuario crear(Usuario usuario) throws UnknownHostException {
        String clave = RandomStringUtils.randomAlphabetic(8);
        InetAddress address = InetAddress.getLocalHost();
        usuario.setClave(DigestUtils.sha256Hex(clave));
        usuario.setFechaCreacion(new Date());
        usuario.setAudIp(address.getHostAddress());
        usuario.setAudFecha(new Date());
        usuario.setAudUsuario("Admin");
        usuario.setNroIntentosFallidos(0);
        usuario.setEstado(EstadoPersonaEnum.CREADO.getValor());
        this.usuarioRepository.save(usuario);
        this.usuarioPerfilRepository.saveAll(usuario.getUsuarioPerfiles());
        return usuario;
    }

    public void cambiarClave(String codigoOMail, String claveAntigua, String claveNueva) throws CambioClaveException {
        Usuario usuario = this.buscarPorCodigoOMail(codigoOMail);
        if (usuario == null) {
            throw new CambioClaveException("No existe el usuario para el codigo o correo provisto");
        }
        claveAntigua = DigestUtils.sha256Hex(claveAntigua);
        if (!usuario.getClave().equals(claveAntigua)) {
            throw new CambioClaveException("La clave antigua no coincide");
        }
        usuario.setClave(DigestUtils.sha256Hex(claveNueva));
        usuario.setFechaCambioClave(new Date());
        this.usuarioRepository.save(usuario);
    }

    public Usuario modificar(Usuario usuario){
        Usuario usuarioDB = this.buscarPorCodigo(usuario.getCodUsuario());
        usuarioDB.setEstado(usuario.getEstado());
        usuarioDB.setNombre(usuario.getNombre());
        usuarioDB.setTelefono(usuario.getTelefono());
        usuarioDB.setOrigen(usuario.getOrigen());
        return this.usuarioRepository.save(usuarioDB);
    }

    public Usuario iniciarSesion(String codigoOMail, String clave) throws InciarSesionException{
        Usuario usuario = this.buscarPorCodigoOMail(codigoOMail);
        if (usuario == null) {
            throw new InciarSesionException("No existe el usuario para el codigo o correo provisto");
        }
        clave = DigestUtils.sha256Hex(clave);
        if (!usuario.getClave().equals(clave)) {
            throw new InciarSesionException("La clave antigua no coincide");
        }

        return usuario;
    }

}
