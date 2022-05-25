/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_nrc_aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EduNrcAula.findAll", query = "SELECT e FROM EduNrcAula e")})
public class EduNrcAula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_nrc_aula")
    private Integer codNrcAula;
    @Basic(optional = false)
    @Column(name = "dia_semana")
    private String diaSemana;
    @Basic(optional = false)
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc"),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo")})
    @ManyToOne(optional = false)
    private EduNrc eduNrc;
    @JoinColumn(name = "cod_aula", referencedColumnName = "cod_aula")
    @ManyToOne
    private OfiAula codAula;

    public EduNrcAula() {
    }

    public EduNrcAula(Integer codNrcAula) {
        this.codNrcAula = codNrcAula;
    }

    public EduNrcAula(Integer codNrcAula, String diaSemana, Date horaInicio, Date horaFin) {
        this.codNrcAula = codNrcAula;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Integer getCodNrcAula() {
        return codNrcAula;
    }

    public void setCodNrcAula(Integer codNrcAula) {
        this.codNrcAula = codNrcAula;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
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

    public OfiAula getCodAula() {
        return codAula;
    }

    public void setCodAula(OfiAula codAula) {
        this.codAula = codAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNrcAula != null ? codNrcAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduNrcAula)) {
            return false;
        }
        EduNrcAula other = (EduNrcAula) object;
        if ((this.codNrcAula == null && other.codNrcAula != null) || (this.codNrcAula != null && !this.codNrcAula.equals(other.codNrcAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduNrcAula[ codNrcAula=" + codNrcAula + " ]";
    }
    
}
