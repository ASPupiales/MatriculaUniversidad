
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorarioPK;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NrcHorarioRepository extends JpaRepository<NrcHorario,NrcHorarioPK>{
    
    List<NrcHorarioRepository> findByPkCodPeriodoOrderByNrcNombreAsc(Integer codPeriodo);
}
