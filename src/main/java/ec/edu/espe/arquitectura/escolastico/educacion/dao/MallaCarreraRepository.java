package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.MallaCarrera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MallaCarreraRepository extends JpaRepository<MallaCarrera, Integer> {

    List<MallaCarrera> findByCodCarreraOrderByNivelAsc(Integer codCarrera);

    List<MallaCarrera> findByCodCarreraAndNivel(Integer codCarrera, Integer nivel);
}
