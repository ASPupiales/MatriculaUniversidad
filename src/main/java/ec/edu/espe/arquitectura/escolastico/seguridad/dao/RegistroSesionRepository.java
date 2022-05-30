package ec.edu.espe.arquitectura.escolastico.seguridad.dao;

import ec.edu.espe.arquitectura.escolastico.seguridad.model.RegistroSesion;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroSesionRepository extends JpaRepository<RegistroSesion, Integer> {

    List<RegistroSesion> findByCodUsuarioAndFechaConexionGreaterThan(String codUsuario, Date fechaConexion);

    List<RegistroSesion> findByCodUsuarioAndResultadoAndFechaConexionGreaterThan(String codUsuario, String resultado, Date fechaConexion);

}
