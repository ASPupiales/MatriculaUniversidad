package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.PerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/perfil")
public class PerfilResource {

    private PerfilService perfilService;

    public PerfilResource(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping(value = "{estado}")
    public ResponseEntity<List<Perfil>> listarPerfilPorEstado(@PathVariable String estado){
        try{
            List<Perfil> perfiles =this.perfilService.listarPerfilesPorEstado(estado);
            return ResponseEntity.ok(perfiles);
        }catch(Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<Perfil> crear(@RequestBody Perfil perfil) {
        try {
            perfil = this.perfilService.crear(perfil);
            return ResponseEntity.ok(perfil);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<Perfil> modificar(@RequestBody Perfil perfil) {
        try {
            perfil = this.perfilService.modificar(perfil);
            return ResponseEntity.ok(perfil);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
