package ec.edu.espe.arquitectura.escolastico.general.dao;

import ec.edu.espe.arquitectura.escolastico.general.model.InstitucionPrincipal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitucionPrincipalRepository extends JpaRepository<InstitucionPrincipal, String> {

    List<InstitucionPrincipal> findByRazonSocialLikeOrderByRazonSocial(String razonSocial);

    List<InstitucionPrincipal> findByNombreComercialLikeOrderByNombreComercial(String nombreComercial);

}
