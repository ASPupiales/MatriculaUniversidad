package ec.edu.espe.arquitectura.escolastico.personal.dao;

import ec.edu.espe.arquitectura.escolastico.personal.model.DireccionPersona;
import ec.edu.espe.arquitectura.escolastico.personal.model.DireccionPersonaPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionPersonaRepository extends JpaRepository<DireccionPersona, DireccionPersonaPK> {

    List<DireccionPersona> findByCodPersona(int codPersona);

    List<DireccionPersona> findByCodPersonaAndTipoDireccion(int codPersona, String tipoDireccion);

    List<DireccionPersona> findByCodPersonaAndPrincipal(int codPersona, String principal);
}
