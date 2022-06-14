package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import ec.edu.espe.arquitectura.escolastico.educacion.service.PeriodoService;

@RestController
@RequestMapping(path = "/periodo")
public class PeriodoResource {

    private PeriodoService service;

    public PeriodoResource(PeriodoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Periodo>> listarPeriodos(@RequestParam Date fechaInicio) {
        try {
            return ResponseEntity.ok(this.service.listarPeriodosFechaInicio(fechaInicio));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> crearPeriodo(@RequestBody Periodo periodo){
        try {
            this.service.crear(periodo);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Periodo> modificarPeriodo(@RequestBody Periodo periodo){
        try {
            this.service.modificar(periodo);
            periodo = this.service.obtenerPorCodigo(periodo.getCodPeriodo());
            return ResponseEntity.ok(periodo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
