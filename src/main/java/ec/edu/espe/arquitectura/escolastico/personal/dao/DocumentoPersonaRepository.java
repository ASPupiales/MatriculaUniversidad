package ec.edu.espe.arquitectura.escolastico.personal.dao;

import ec.edu.espe.arquitectura.escolastico.personal.model.DocumentoPersona;
import ec.edu.espe.arquitectura.escolastico.personal.model.DocumentoPersonaPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoPersonaRepository extends JpaRepository<DocumentoPersona, DocumentoPersonaPK> {

    DocumentoPersona findByCodPersonaAndCodTipoDocumento(int codPersona, String codTipoDocumento);

    List<DocumentoPersona> findByCodPersonaAndEstado(int codPersona, String estado);
}
