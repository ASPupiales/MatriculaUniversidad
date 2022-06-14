package ec.edu.espe.arquitectura.escolastico.educacion.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import ec.edu.espe.arquitectura.escolastico.educacion.MatriculaException;
import ec.edu.espe.arquitectura.escolastico.educacion.NotFoundException;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.service.MatriculaService;

@RestController
@RequestMapping("/matricula")
public class MatriculaResource {

    private MatriculaService matriculaService;

    public MatriculaResource(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping
    public ResponseEntity<String> matricularse(@RequestBody Map<String, Object> request){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Matricula matricula = objectMapper.convertValue(request.get("matricula"), Matricula.class);
            ArrayList object = objectMapper.convertValue(request.get("nrcs"), ArrayList.class);
            List<Nrc> nrcs = new ArrayList<>();
            for (Object obj : object) {
                nrcs.add(objectMapper.convertValue(obj, Nrc.class));
            }
            this.matriculaService.matricularse(matricula, nrcs);

            return ResponseEntity.ok().build();
        } catch(NotFoundException | MatriculaException n){
            return ResponseEntity.badRequest().body(n.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> listarMatriculas(@RequestParam Integer codAlumno){
        try {
            return ResponseEntity.ok(this.matriculaService.listarMatriculasPorAlumno(codAlumno));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
