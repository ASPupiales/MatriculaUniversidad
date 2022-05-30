package ec.edu.espe.arquitectura.escolastico.general.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ec.edu.espe.arquitectura.escolastico.general.model.Error;

public interface ErrorRepository extends JpaRepository<Error, String> {

}
