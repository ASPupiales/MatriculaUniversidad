package ec.edu.espe.arquitectura.escolastico.educacion.dao;

import ec.edu.espe.arquitectura.escolastico.educacion.model.Matricula;
import ec.edu.espe.arquitectura.escolastico.educacion.model.MatriculaPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, MatriculaPK> {

    Matricula findByCodPeriodoAndPkCodAlumno(Integer codPeriodo, Integer codPersona);

    List<Matricula> findByTipoAndPkCodAlumnoOrderByFechaDesc(String tipo, Integer codAlumno);

    List<Matricula> findByTipoAndCodPeriodoAndCodCarreraOrderByFechaDesc(String tipo, Integer codPeriodo, Integer codCarrera);

    List<Matricula> findByPkCodAlumnoOrderByFechaDesc(Integer codAlumno);

}
