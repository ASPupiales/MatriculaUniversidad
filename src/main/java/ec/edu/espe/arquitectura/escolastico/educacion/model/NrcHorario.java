package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.orgfisico.model.Aula;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "edu_nrc_horario")
public class NrcHorario implements Serializable {

    private static final long serialVersionUID = 108L;
    @EmbeddedId
    private NrcHorarioPK pk;

    @Column(name = "hora_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;

    @Column(name = "hora_fin", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFin;

    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    @JsonIgnore
    private Nrc nrc;

    @JoinColumn(name = "cod_aula", referencedColumnName = "cod_aula", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = true)
    @JsonManagedReference
    private Aula aula;

    public NrcHorario() {
    }

    public NrcHorario(NrcHorarioPK nrcHorarioPK) {
        this.pk = nrcHorarioPK;
    }

    public NrcHorario(Integer codNrc, Integer codPeriodo, Integer codDepartamento, Integer codMateria, Integer codAula, String diaSemana) {
        this.pk = new NrcHorarioPK(codNrc, codPeriodo, codDepartamento, codMateria, codAula, diaSemana);
    }

    public NrcHorarioPK getPk() {
        return pk;
    }

    public void setPk(NrcHorarioPK pk) {
        this.pk = pk;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Nrc getNrc() {
        return nrc;
    }

    public void setNrc(Nrc nrc) {
        this.nrc = nrc;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof NrcHorario)) {
            return false;
        }
        NrcHorario other = (NrcHorario) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nrcHorarioPK=" + pk;
    }

}
