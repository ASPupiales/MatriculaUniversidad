package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Carrera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    Carrera findBySiglas(String siglas);

    List<Carrera> findByCodDepartamentoOrderByNombreAsc(Integer codDepartamento);

    List<Carrera> findByNombreLikeOrderByNombreAsc(String nombrePattern);

}
