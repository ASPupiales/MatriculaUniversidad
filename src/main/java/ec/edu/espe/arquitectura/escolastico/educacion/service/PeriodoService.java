package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.PeriodoRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Periodo;

@Service
public class PeriodoService {

    private PeriodoRepository periodoRepository;

    public PeriodoService(PeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }

    public Periodo obtenerPorCodigo(Integer codigo) {
        Optional<Periodo> periodoOpt = this.periodoRepository.findById(codigo);
        if (periodoOpt.isPresent()) {
            return periodoOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Periodo periodo) {
        this.periodoRepository.save(periodo);
    }

    public void modificar(Periodo periodo) {
        Periodo periodoBD = this.obtenerPorCodigo(periodo.getCodPeriodo());
        periodoBD.setNombre(periodo.getNombre());
        periodoBD.setNivel(periodo.getNivel());
        periodoBD.setFechaInicio(periodo.getFechaInicio());
        periodoBD.setFechaFin(periodo.getFechaFin());
        periodoBD.setParciales(periodo.getParciales());
        this.periodoRepository.save(periodoBD);
    }

    public List<Periodo> listarPeriodosFechaInicio(Date fechaInicio) {
        return this.periodoRepository.findByFechaInicioGreaterThanEqual(fechaInicio);
    }

    public List<Periodo> listarPeriodos() {
        return this.periodoRepository.findAll();
    }

}
