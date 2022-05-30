
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoRepository extends JpaRepository<Periodo, Short>{
    
    List<Periodo> findByNombreAndNivel(String nombre, String nivel);
    
    List<Periodo> findByNombreAndFechaFinLessThanEqual(Date nombre, Date fechaFin);
            
}
