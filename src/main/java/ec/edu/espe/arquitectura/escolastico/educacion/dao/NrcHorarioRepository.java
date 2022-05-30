
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorarioPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NrcHorarioRepository extends JpaRepository<NrcHorario,NrcHorarioPK>{
    
    
}
