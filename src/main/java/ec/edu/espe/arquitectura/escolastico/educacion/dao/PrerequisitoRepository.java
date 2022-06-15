package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Prerequisito;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrerequisitoRepository extends JpaRepository<Prerequisito, Integer> {

    List<Prerequisito> findByCodMateria(Integer codMateria);

}
