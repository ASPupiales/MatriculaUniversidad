package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.HistTipoPersona;
import ec.edu.espe.arquitectura.escolastico.persona.model.HistTipoPersonaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistTipoPersonaRepository extends JpaRepository<HistTipoPersona, HistTipoPersonaPK> {

}
