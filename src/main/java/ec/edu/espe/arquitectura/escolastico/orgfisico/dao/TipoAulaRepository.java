package ec.edu.espe.arquitectura.escolastico.orgfisico.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisico.model.TipoAula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoAulaRepository extends JpaRepository<TipoAula, String> {

    List<TipoAula> findByCodTipoAula(String codTipoAula);
}
