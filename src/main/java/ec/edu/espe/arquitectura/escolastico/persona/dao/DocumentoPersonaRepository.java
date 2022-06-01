package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.DocumentoPersona;
import ec.edu.espe.arquitectura.escolastico.persona.model.DocumentoPersonaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoPersonaRepository extends JpaRepository<DocumentoPersona, DocumentoPersonaPK> {

}
