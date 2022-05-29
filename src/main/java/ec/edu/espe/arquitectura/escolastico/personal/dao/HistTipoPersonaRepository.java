package ec.edu.espe.arquitectura.escolastico.personal.dao;

import ec.edu.espe.arquitectura.escolastico.personal.model.HistTipoPersona;
import ec.edu.espe.arquitectura.escolastico.personal.model.HistTipoPersonaPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistTipoPersonaRepository extends JpaRepository<HistTipoPersona, HistTipoPersonaPK> {

    List<HistTipoPersona> findByCodPersonaAndFechaFinIsNull(String codPersona);
}
