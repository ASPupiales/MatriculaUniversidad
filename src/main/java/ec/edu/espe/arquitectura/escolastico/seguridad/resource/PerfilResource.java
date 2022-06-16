package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.PerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

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

    @PostMapping(value = "/asignarFuncionalidad")
    public ResponseEntity asignarFuncionalidad(@RequestBody Map<String,String> json) {
        try {
            this.perfilService.asignarFuncionalidadPerfil(json.get("codPerfil"), json.get("codFuncionalidad"));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
