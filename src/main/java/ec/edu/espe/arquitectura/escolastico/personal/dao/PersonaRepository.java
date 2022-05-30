package ec.edu.espe.arquitectura.escolastico.personal.dao;

import ec.edu.espe.arquitectura.escolastico.personal.model.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    Persona findByEmail(String email);

    Persona findByTipoIdentificacionAndIdentificacion(String tipoIdentificacion, String identificacion);

    Persona findByCodigoAlterno(String codigoAlterno);
    
    List<Persona> findByNombreCompletoLike(String nombreCompletoPattern);

    List<Persona> findByCodTipoPersonaAndEstado(String codTipoPersona, String estado);

    List<Persona> findByCodTipoPersonaAndEstadoAndNombreCompletoLike(String codTipoPersona, String estado, String nombreCompletoPattern);
}
