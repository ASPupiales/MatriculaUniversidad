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

import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import ec.edu.espe.arquitectura.escolastico.educacion.service.DepartamentoService;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoResource {
    private DepartamentoService service;

    public DepartamentoResource(DepartamentoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Departamento>> getDepartamentos() {
        return ResponseEntity.ok(this.service.listarDepartamentos());
    }

    @GetMapping(value = "/{siglas}")
    public ResponseEntity<Departamento> getDepartamentoBySiglas(@PathVariable String siglas) {
        return ResponseEntity.ok(this.service.obtenerPorSiglas(siglas));
    }

    @GetMapping(value = "/nombre/{nombrePattern}")
    public ResponseEntity<List<Departamento>> getDepartamentoByNombre(@PathVariable String nombrePattern) {
        return ResponseEntity.ok(this.service.listarDepartamentosPorNombre(nombrePattern));
    }

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Departamento departamento) {
        try {
            this.service.crear(departamento);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Departamento> modificar(@RequestBody Departamento departamento) {
        try {
            this.service.modificar(departamento);
            departamento = this.service.obtenerPorCodigo(departamento.getCodDepartamento());
            return ResponseEntity.ok(departamento);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
    
}
