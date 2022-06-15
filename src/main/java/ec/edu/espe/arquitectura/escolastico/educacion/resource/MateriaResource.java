package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Materia;
import ec.edu.espe.arquitectura.escolastico.educacion.service.MateriaService;

@RestController
@RequestMapping(path = "/materia")
public class MateriaResource {
    private MateriaService service;

    public MateriaResource(MateriaService service) {
        this.service = service;
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<List<Materia>> getMateriasPorDepartamento(@PathVariable Integer codigo) {
        return ResponseEntity.ok(this.service.listarMateriasPorDepartamento(codigo));
    }

    @GetMapping(value = "/nombre/{nombrePattern}")
    public ResponseEntity<List<Materia>> getCarrerasByDepartamento(@PathVariable String nombrePattern) {
        return ResponseEntity.ok(this.service.listarMateriasPorNombre(nombrePattern));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Materia materia) {
        try {
            this.service.crear(materia);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Materia> modificar(@RequestBody Materia materia) {
        try {
            this.service.modificar(materia);
            materia = this.service.obtenerPorCodigo(materia.getPk());
            return ResponseEntity.ok(materia);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}
