package ec.edu.espe.arquitectura.escolastico.personal.dao;

import ec.edu.espe.arquitectura.escolastico.personal.model.TipoDiscapacidad;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDiscapacidadRepository extends JpaRepository<TipoDiscapacidad, String> {

    List<TipoDiscapacidad> findAllOrderByNombre(String nombre);
}
