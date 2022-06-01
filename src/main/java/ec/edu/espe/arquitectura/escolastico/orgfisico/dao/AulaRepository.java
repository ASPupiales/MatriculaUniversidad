package ec.edu.espe.arquitectura.escolastico.orgfisico.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisico.model.Aula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AulaRepository extends JpaRepository<Aula, Integer> {

    Aula findByCodAlterno(String codAlterno);

    List<Aula> findByCodTipoAula(String codTipoAula);

    List<Aula> findByCodEdificio(String codEdificio);

    List<Aula> findByCodEdificioBloque(String codEdificioBloque);

    List<Aula> findByCodTipoAulaAndCapacidadGreaterThanOrderByCapacidadDesc(String codTipoAula, Integer capacidad);

    List<Aula> findByCodEdificioAndCapacidadGreaterThanOrderByCapacidadDesc(String codEdificio, Integer capacidad);

    List<Aula> findByCodEdificioBloqueAndCapacidadGreaterThanOrderByCapacidadDesc(String codEdificioBloque, Integer capacidad);

}
