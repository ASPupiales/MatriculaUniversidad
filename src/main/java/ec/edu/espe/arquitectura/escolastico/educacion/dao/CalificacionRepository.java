package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.CalificacionPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Calificacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalificacionRepository extends JpaRepository<Calificacion, CalificacionPK> {

    Calificacion findByPkCodPersonaAndPkCodNrc(Integer codPersona, Integer codNrc);
    
    List<Calificacion> findByCodPeriodoAndPkCodPersona(Integer codPeriodo, Integer codPersona);
}
