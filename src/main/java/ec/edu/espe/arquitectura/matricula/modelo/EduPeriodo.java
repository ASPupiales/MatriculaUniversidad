/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_periodo")
@NamedQueries({
    @NamedQuery(name = "EduPeriodo.findAll", query = "SELECT e FROM EduPeriodo e")})
public class EduPeriodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_periodo", nullable = false)
    private Short codPeriodo;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "nivel", nullable = false, length = 32)
    private String nivel;
    @Basic(optional = false)
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @Column(name = "parciales", nullable = false)
    private short parciales;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "eduPeriodo")
    private EduNrc eduNrc;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codPeriodo")
    private EduMatricula eduMatricula;

    public EduPeriodo() {
    }

    public EduPeriodo(Short codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public EduPeriodo(Short codPeriodo, String nombre, String nivel, Date fechaInicio, Date fechaFin, short parciales) {
        this.codPeriodo = codPeriodo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.parciales = parciales;
    }

    public Short getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Short codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public short getParciales() {
        return parciales;
    }

    public void setParciales(short parciales) {
        this.parciales = parciales;
    }

    public EduNrc getEduNrc() {
        return eduNrc;
    }

    public void setEduNrc(EduNrc eduNrc) {
        this.eduNrc = eduNrc;
    }

    public EduMatricula getEduMatricula() {
        return eduMatricula;
    }

    public void setEduMatricula(EduMatricula eduMatricula) {
        this.eduMatricula = eduMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPeriodo != null ? codPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduPeriodo)) {
            return false;
        }
        EduPeriodo other = (EduPeriodo) object;
        if ((this.codPeriodo == null && other.codPeriodo != null) || (this.codPeriodo != null && !this.codPeriodo.equals(other.codPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduPeriodo[ codPeriodo=" + codPeriodo + " ]";
    }
    
}
