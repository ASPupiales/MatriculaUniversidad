package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Funcionalidad;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author labox
 */
public interface FuncionalidadRepository extends Repository<Funcionalidad, Integer> {

    List<Funcionalidad> findByCodModuloAndEstado(String codModulo, String estado);

}
