package ec.edu.espe.arquitectura.escolastico.personal.dao;

import ec.edu.espe.arquitectura.escolastico.personal.model.FamiliarPersona;
import ec.edu.espe.arquitectura.escolastico.personal.model.FamiliarPersonaPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliarPersonaRepository extends JpaRepository<FamiliarPersona, FamiliarPersonaPK> {

    List<FamiliarPersona> findByTipoFamiliarAndCodPersona(String tipoFamiliar, int codPersona);
    
    List<FamiliarPersona> findByCodPersona(int codPersona);
    
    List<FamiliarPersona> findByNombreLike(String nombre);
}
