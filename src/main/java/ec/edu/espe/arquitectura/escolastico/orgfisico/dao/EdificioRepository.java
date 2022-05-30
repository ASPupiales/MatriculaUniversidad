package ec.edu.espe.arquitectura.escolastico.orgfisico.dao;

import ec.edu.espe.arquitectura.escolastico.orgfisico.model.Edificio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Edificio, String> {

    List<Edificio> findByCodSede(String codSede);
}
