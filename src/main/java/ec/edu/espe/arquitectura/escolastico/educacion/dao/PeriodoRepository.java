package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {

    List<Periodo> findByNombreLikeAndNivelOrderByNombre(String nombrePattern, String nivel);

    List<Periodo> findByFechaInicioGreaterThanEqual(Date fechaFin);

}
