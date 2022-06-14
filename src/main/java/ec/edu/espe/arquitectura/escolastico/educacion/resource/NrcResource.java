package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.service.NrcService;

@RestController
@RequestMapping(path = "/nrc")
public class NrcResource {

    private NrcService service;

    public NrcResource(NrcService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Nrc>> listarNrcPorPeriodoYDepartamento(@RequestParam("codPeriodo") Integer codPeriodo, @RequestParam("codDepartamento") Integer codDepartamento){
        try {
            return ResponseEntity.ok(this.service.listarNrcPorPeriodoYDepartamento(codPeriodo, codDepartamento));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crearNrc(@RequestBody Nrc nrc){
        try {
            
            this.service.crear(nrc);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Nrc> modificarNrc(@RequestBody Nrc nrc){
        try {
            this.service.modificar(nrc);
            nrc = this.service.obtenerPorCodigo(nrc.getPk());
            return ResponseEntity.ok(nrc);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
