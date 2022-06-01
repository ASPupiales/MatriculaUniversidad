package ec.edu.espe.arquitectura.escolastico.orgfisico.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisico.model.EdificioBloque;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioBloqueRepository extends JpaRepository<EdificioBloque, String> {

    List<EdificioBloque> findByCodEdificioOrderByNombreBloqueAsc(String codEdificio);
}
