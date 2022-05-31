package ec.edu.espe.arquitectura.escolastico.orgfisico.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisico.model.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitucionRepository extends JpaRepository<Institucion, Short> {

    Institucion findByRuc(String ruc);
}
