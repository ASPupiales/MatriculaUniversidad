package ec.edu.espe.arquitectura.escolastico.seguridad.resource;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Funcionalidad;
import ec.edu.espe.arquitectura.escolastico.seguridad.service.FuncionalidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/funcionalidad")
public class FuncionalidadResource {
    private FuncionalidadService funcionalidadService;

    public FuncionalidadResource(FuncionalidadService funcionalidadService) {
        this.funcionalidadService = funcionalidadService;
    }

    @GetMapping(value = "{codModulo}")
    public ResponseEntity<List<Funcionalidad>> listarFuncionalidadPorModulo(@PathVariable String codModulo) {
        return ResponseEntity.ok(this.funcionalidadService.buscarCodigoModulo(codModulo));
    }

    @PostMapping
    public ResponseEntity<Funcionalidad> crear(@RequestBody Funcionalidad funcionalidad) {
        try {
            funcionalidad = this.funcionalidadService.crear(funcionalidad);
            return ResponseEntity.ok(funcionalidad);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
