package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.HistTipoPersona;
import ec.edu.espe.arquitectura.escolastico.persona.model.HistTipoPersonaPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistTipoPersonaRepository extends JpaRepository<HistTipoPersona, HistTipoPersonaPK> {

    List<HistTipoPersona> findByPkCodPersona(String codPersona);
    
    List<HistTipoPersona> findByPkCodPersonaAndFechaFinIsNull(String codPersona);
}
