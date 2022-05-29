package ec.edu.espe.arquitectura.escolastico.personal.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoRepository, String> {

    List<TipoDocumentoRepository> findAllOrderByNombre(String nombre);
}
