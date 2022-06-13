package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.EstadoPersonaEnum;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioResource {

    private UsuarioService usuarioService;

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
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        try {
            usuario = this.usuarioService.crear(usuario);
            return ResponseEntity.ok(usuario);
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
}

