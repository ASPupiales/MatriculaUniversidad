package ec.edu.espe.arquitectura.escolastico.persona.dao;

import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    Persona findByEmail(String email);

    Persona findByTipoIdentificacionAndIdentificacion(String tipoIdentificacion, String identificacion);

    Persona findByCodigoAlterno(String codigoAlterno);

    List<Persona> findByNombreCompletoLikeOrderByNombreCompletoAsc(String nombreCompletoPattern);

    List<Persona> findByCodTipoPersonaAndEstadoOrderByNombreCompletoAsc(String codTipoPersona, String estado);

    List<Persona> findByCodTipoPersonaAndEstadoAndNombreCompletoLikeOrderByNombreCompletoAsc(String codTipoPersona, String estado, String nombreCompletoPattern);
}
