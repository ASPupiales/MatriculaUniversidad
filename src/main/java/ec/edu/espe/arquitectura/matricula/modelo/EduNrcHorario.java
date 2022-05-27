/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_nrc_horario")
@NamedQueries({
    @NamedQuery(name = "EduNrcHorario.findAll", query = "SELECT e FROM EduNrcHorario e")})
public class EduNrcHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EduNrcHorarioPK eduNrcHorarioPK;
    @Basic(optional = false)
    @Column(name = "hora_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @Column(name = "hora_fin", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EduNrc eduNrc;
    @JoinColumn(name = "cod_aula", referencedColumnName = "cod_aula", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private OfiAula ofiAula;

    public EduNrcHorario() {
    }

    public EduNrcHorario(EduNrcHorarioPK eduNrcHorarioPK) {
        this.eduNrcHorarioPK = eduNrcHorarioPK;
    }

    public EduNrcHorario(EduNrcHorarioPK eduNrcHorarioPK, Date horaInicio, Date horaFin) {
        this.eduNrcHorarioPK = eduNrcHorarioPK;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public EduNrcHorario(short codNrc, short codPeriodo, int codDepartamento, int codMateria, int codAula, String diaSemana) {
        this.eduNrcHorarioPK = new EduNrcHorarioPK(codNrc, codPeriodo, codDepartamento, codMateria, codAula, diaSemana);
    }

    public EduNrcHorarioPK getEduNrcHorarioPK() {
        return eduNrcHorarioPK;
    }

    public void setEduNrcHorarioPK(EduNrcHorarioPK eduNrcHorarioPK) {
        this.eduNrcHorarioPK = eduNrcHorarioPK;
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

    public EduNrc getEduNrc() {
        return eduNrc;
    }

    public void setEduNrc(EduNrc eduNrc) {
        this.eduNrc = eduNrc;
    }

    public OfiAula getOfiAula() {
        return ofiAula;
    }

    public void setOfiAula(OfiAula ofiAula) {
        this.ofiAula = ofiAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduNrcHorarioPK != null ? eduNrcHorarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduNrcHorario)) {
            return false;
        }
        EduNrcHorario other = (EduNrcHorario) object;
        if ((this.eduNrcHorarioPK == null && other.eduNrcHorarioPK != null) || (this.eduNrcHorarioPK != null && !this.eduNrcHorarioPK.equals(other.eduNrcHorarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduNrcHorario[ eduNrcHorarioPK=" + eduNrcHorarioPK + " ]";
    }
    
}
