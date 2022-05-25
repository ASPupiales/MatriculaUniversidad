/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EduMatricula.findAll", query = "SELECT e FROM EduMatricula e")})
public class EduMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_matricula")
    private Integer codMatricula;
    @Basic(optional = false)
    @Column(name = "tipo")
    private int tipo;
    @Basic(optional = false)
    @Column(name = "modo")
    private String modo;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "costo")
    private double costo;
    @JoinColumn(name = "cod_inscripcion_estudiante", referencedColumnName = "cod_inscripcion_carrera")
    @ManyToOne(optional = false)
    private EduInscripcionCarrera codInscripcionEstudiante;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc"),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo")})
    @ManyToOne(optional = false)
    private EduNrc eduNrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInscripcion")
    private List<EduCalificacion> eduCalificacionList;

    public EduMatricula() {
    }

    public EduMatricula(Integer codMatricula) {
        this.codMatricula = codMatricula;
    }

    public EduMatricula(Integer codMatricula, int tipo, String modo, Date fecha, double costo) {
        this.codMatricula = codMatricula;
        this.tipo = tipo;
        this.modo = modo;
        this.fecha = fecha;
        this.costo = costo;
    }

    public Integer getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(Integer codMatricula) {
        this.codMatricula = codMatricula;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public EduInscripcionCarrera getCodInscripcionEstudiante() {
        return codInscripcionEstudiante;
    }

    public void setCodInscripcionEstudiante(EduInscripcionCarrera codInscripcionEstudiante) {
        this.codInscripcionEstudiante = codInscripcionEstudiante;
    }

    public EduNrc getEduNrc() {
        return eduNrc;
    }

    public void setEduNrc(EduNrc eduNrc) {
        this.eduNrc = eduNrc;
    }

    @XmlTransient
    public List<EduCalificacion> getEduCalificacionList() {
        return eduCalificacionList;
    }

    public void setEduCalificacionList(List<EduCalificacion> eduCalificacionList) {
        this.eduCalificacionList = eduCalificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMatricula != null ? codMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduMatricula)) {
            return false;
        }
        EduMatricula other = (EduMatricula) object;
        if ((this.codMatricula == null && other.codMatricula != null) || (this.codMatricula != null && !this.codMatricula.equals(other.codMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduMatricula[ codMatricula=" + codMatricula + " ]";
    }
    
}
