
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaNrcPK;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaNrcRepository extends JpaRepository<MatriculaNrc, MatriculaNrcPK>{
    
    List<MatriculaNrc> findByPkCodMatriculaAndPkCodPersonaAndPkCodPeriodo(String codMatricula, Integer codPersona, Integer codPeriodo);

    List<MatriculaNrc> findByPkCodPersonaAndPkCodMateria(Integer codPersona, Integer codMateria);

}
