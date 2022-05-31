package ec.edu.espe.arquitectura.escolastico.personal.dao;

import ec.edu.espe.arquitectura.escolastico.personal.model.TipoDiscapacidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDiscapacidadRepository extends JpaRepository<TipoDiscapacidad, String> {

    TipoDiscapacidad findByNombre(String nombre);
}
