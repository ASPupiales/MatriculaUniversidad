package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Modulo;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author labox
 */
public interface ModuloRepository extends Repository<Modulo, String> {

    List<Modulo> findByEstado(String estado);

}
