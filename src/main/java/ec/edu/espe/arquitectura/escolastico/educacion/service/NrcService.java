package ec.edu.espe.arquitectura.escolastico.educacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcHorarioRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.dao.NrcRepository;
import ec.edu.espe.arquitectura.escolastico.educacion.model.Nrc;
import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcPK;

@Service
public class NrcService {

    private NrcRepository nrcRepository;
    private NrcHorarioRepository nrcHorarioRepository;

    public NrcService(NrcRepository nrcRepository, NrcHorarioRepository nrcHorarioRepository) {
        this.nrcRepository = nrcRepository;
        this.nrcHorarioRepository = nrcHorarioRepository;
    }

    public Nrc obtenerPorCodigo(NrcPK pk) {
        Optional<Nrc> nrcOpt = this.nrcRepository.findById(pk);
        if (nrcOpt.isPresent()) {
            return nrcOpt.get();
        } else {
            return null;
        }
    }

    public void crear(Nrc nrc) {

        this.nrcRepository.save(nrc);
        this.nrcHorarioRepository.saveAll(nrc.getNrcHorarios());

    }

    public void modificar(Nrc nrc) {
        Nrc nrcBd = this.obtenerPorCodigo(nrc.getPk());
        nrcBd.setCodDocente(nrc.getCodDocente());
        nrcBd.setCupoDisponible(nrc.getCupoDisponible());
        nrcBd.setCupoRegistrado(nrc.getCupoRegistrado());
        nrcBd.setNombre(nrc.getNombre());
        this.nrcRepository.save(nrcBd);
    }

    public List<Nrc> listarNrcPorPeriodoYDocente(Integer codPeriodo, Integer codDocente) {
        return this.nrcRepository.findByPkCodPeriodoAndCodDocenteOrderByMateriaNombreAsc(codPeriodo, codDocente);
    }

    public List<Nrc> listarNrcPorPeriodoYDepartamento(Integer codPeriodo, Integer codDepartamento) {
        return this.nrcRepository.findByPkCodPeriodoAndPkCodDepartamentoOrderByMateriaNombreAsc(codPeriodo,
                codDepartamento);
    }

}
