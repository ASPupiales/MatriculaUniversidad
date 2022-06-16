package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.RegistroSesionService;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.json.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioResource {

    private UsuarioService usuarioService;
    private RegistroSesionService registroSesionService;

    public UsuarioResource(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(value = "/estado/{estado}")
    public ResponseEntity<List<Usuario>> obtenerUsuariosPorEstado(@PathVariable EstadoPersonaEnum estado) {
        return ResponseEntity.ok(this.usuarioService.buscarPorEstado(estado));
    }

    @GetMapping(value = "/nombre/{nombre}")
    public ResponseEntity<List<Usuario>> ObtenerUsuariosPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(this.usuarioService.buscarPorNombre(nombre));
    }

    @PostMapping
    public ResponseEntity crear(@RequestBody Usuario usuario) {
        try {
            String clave = this.usuarioService.crear(usuario);
            JSONObject response = new JSONObject();
            response.put("clave", clave);
            return ResponseEntity.ok(response.toMap());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Usuario> modificar(@RequestBody Usuario usuario) {
        try {
            this.usuarioService.modificar(usuario);
            usuario = this.usuarioService.buscarPorCodigo(usuario.getCodUsuario());
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/clave")
    public ResponseEntity cambiarClave(@RequestBody Map<String,String> json) {
        try {
            this.usuarioService.cambiarClave(json.get("codUsuario"),json.get("claveAntigua"),json.get("clave"));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/iniciarSesion")
    public ResponseEntity iniciarSesion(@RequestBody Usuario usuario) {
        try {
            String respuestaAcceso = this.usuarioService.iniciarSesion(usuario.getCodUsuario(), usuario.getClave());
            JSONObject response = new JSONObject();
            response.put("Info", respuestaAcceso);
            return ResponseEntity.ok(response.toMap());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/asignarPerfil")
    public ResponseEntity asignarPerfil(@RequestBody Map<String,String> json) {
        try {
            this.usuarioService.asignarPerfilUsuario(json.get("codUsuario"), json.get("codPerfil"));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}

