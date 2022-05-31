
package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Departamento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
    
    Departamento findBySiglas(String siglas);
    
    List<Departamento> findBySiglasLike(String siglasPattern);
}
