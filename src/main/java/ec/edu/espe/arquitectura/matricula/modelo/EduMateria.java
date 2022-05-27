/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EduMateria.findAll", query = "SELECT e FROM EduMateria e")})
public class EduMateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EduMateriaPK eduMateriaPK;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "creditos")
    private BigDecimal creditos;
    @Basic(optional = false)
    @Column(name = "horas")
    private BigDecimal horas;
    @Basic(optional = false)
    @Column(name = "ponderacion")
    private BigDecimal ponderacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMateria")
    private List<EduNrc> eduNrcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMateria")
    private List<EduMallaCarrera> eduMallaCarreraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMateria")
    private List<EduPrerequisito> eduPrerequisitoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMateria1")
    private List<EduPrerequisito> eduPrerequisitoList1;
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EduDepartamento eduDepartamento;

    public EduMateria() {
    }

    public EduMateria(EduMateriaPK eduMateriaPK) {
        this.eduMateriaPK = eduMateriaPK;
    }

    public EduMateria(EduMateriaPK eduMateriaPK, String nombre, BigDecimal creditos, BigDecimal horas, BigDecimal ponderacion) {
        this.eduMateriaPK = eduMateriaPK;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas = horas;
        this.ponderacion = ponderacion;
    }

    public EduMateria(int codMateria, int codDepartamento) {
        this.eduMateriaPK = new EduMateriaPK(codMateria, codDepartamento);
    }

    public EduMateriaPK getEduMateriaPK() {
        return eduMateriaPK;
    }

    public void setEduMateriaPK(EduMateriaPK eduMateriaPK) {
        this.eduMateriaPK = eduMateriaPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCreditos() {
        return creditos;
    }

    public void setCreditos(BigDecimal creditos) {
        this.creditos = creditos;
    }

    public BigDecimal getHoras() {
        return horas;
    }

    public void setHoras(BigDecimal horas) {
        this.horas = horas;
    }

    public BigDecimal getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(BigDecimal ponderacion) {
        this.ponderacion = ponderacion;
    }

    @XmlTransient
    public List<EduNrc> getEduNrcList() {
        return eduNrcList;
    }

    public void setEduNrcList(List<EduNrc> eduNrcList) {
        this.eduNrcList = eduNrcList;
    }

    @XmlTransient
    public List<EduMallaCarrera> getEduMallaCarreraList() {
        return eduMallaCarreraList;
    }

    public void setEduMallaCarreraList(List<EduMallaCarrera> eduMallaCarreraList) {
        this.eduMallaCarreraList = eduMallaCarreraList;
    }

    @XmlTransient
    public List<EduPrerequisito> getEduPrerequisitoList() {
        return eduPrerequisitoList;
    }

    public void setEduPrerequisitoList(List<EduPrerequisito> eduPrerequisitoList) {
        this.eduPrerequisitoList = eduPrerequisitoList;
    }

    @XmlTransient
    public List<EduPrerequisito> getEduPrerequisitoList1() {
        return eduPrerequisitoList1;
    }

    public void setEduPrerequisitoList1(List<EduPrerequisito> eduPrerequisitoList1) {
        this.eduPrerequisitoList1 = eduPrerequisitoList1;
    }

    public EduDepartamento getEduDepartamento() {
        return eduDepartamento;
    }

    public void setEduDepartamento(EduDepartamento eduDepartamento) {
        this.eduDepartamento = eduDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduMateriaPK != null ? eduMateriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduMateria)) {
            return false;
        }
        EduMateria other = (EduMateria) object;
        if ((this.eduMateriaPK == null && other.eduMateriaPK != null) || (this.eduMateriaPK != null && !this.eduMateriaPK.equals(other.eduMateriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduMateria[ eduMateriaPK=" + eduMateriaPK + " ]";
    }
    
}
