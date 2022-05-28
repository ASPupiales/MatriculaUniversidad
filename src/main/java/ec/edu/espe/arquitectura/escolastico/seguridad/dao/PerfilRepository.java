package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Perfil;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author labox
 */
public interface PerfilRepository extends Repository<Perfil, String> {

    List<Perfil> findByEstado(String estado);

}
