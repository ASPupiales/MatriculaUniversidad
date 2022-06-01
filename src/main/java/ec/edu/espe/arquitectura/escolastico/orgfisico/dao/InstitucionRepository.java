package ec.edu.espe.arquitectura.escolastico.orgfisico.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisico.model.Institucion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitucionRepository extends JpaRepository<Institucion, Integer> {

    Institucion findByRuc(String ruc);
    
    List<Institucion> findByNombreComercialLikeOrderByNombreComercialAsc(String nombreComercial);
}
