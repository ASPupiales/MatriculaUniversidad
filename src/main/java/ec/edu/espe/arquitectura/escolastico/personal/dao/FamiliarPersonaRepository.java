package ec.edu.espe.arquitectura.escolastico.personal.dao;

import ec.edu.espe.arquitectura.escolastico.personal.model.FamiliarPersona;
import ec.edu.espe.arquitectura.escolastico.personal.model.FamiliarPersonaPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamiliarPersonaRepository extends JpaRepository<FamiliarPersona, FamiliarPersonaPK> {

    List<FamiliarPersona> findByTipoFamiliar(String tipoFamiliar);
    
    List<FamiliarPersona> findByCodPersona(int codPersona);
    
    List<FamiliarPersona> findByNombreLike(String nombre);
}
