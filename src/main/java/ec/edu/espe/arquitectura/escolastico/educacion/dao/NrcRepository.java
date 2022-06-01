package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NrcRepository extends JpaRepository<Nrc, NrcPK> {

    List<Nrc> findByPkCodPeriodoAndPkCodDepartamentoOrderByMateriaNombreAsc(Integer codPeriodo, Integer codDepartamento);

    List<Nrc> findByPkCodPeriodoAndCodDocenteOrderByMateriaNombreAsc(Integer codPeriodo, Integer codDocente);

}
