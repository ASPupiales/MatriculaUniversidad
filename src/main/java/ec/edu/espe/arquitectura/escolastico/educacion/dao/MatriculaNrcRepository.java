
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrcPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaNrcRepository extends JpaRepository<MatriculaNrc, MatriculaNrcPK>{
    
}
