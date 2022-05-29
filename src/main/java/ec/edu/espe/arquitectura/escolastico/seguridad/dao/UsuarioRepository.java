package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findByMail(String mail);

    List<Usuario> findByNombreLikeOrderByNombre(String nombrePattern);

    List<Usuario> findByEstado(String estado);

    List<Usuario> findByNombreLikeAndEstado(String nombrePattern, String estado);

}
