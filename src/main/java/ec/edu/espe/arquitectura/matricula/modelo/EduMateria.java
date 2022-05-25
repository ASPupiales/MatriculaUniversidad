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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_materia")
    private Integer codMateria;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMateria")
    private List<EduNrc> eduNrcList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMateria")
    private List<EduMallaCarrera> eduMallaCarreraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codMateriaPadre")
    private List<EduPrerequisito> eduPrerequisitoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduCodMateria")
    private List<EduPrerequisito> eduPrerequisitoList1;
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento")
    @ManyToOne(optional = false)
    private EduDepartamento codDepartamento;

    public EduMateria() {
    }

    public EduMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    public EduMateria(Integer codMateria, String nombre, BigDecimal creditos, BigDecimal horas, BigDecimal ponderacion) {
        this.codMateria = codMateria;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas = horas;
        this.ponderacion = ponderacion;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Integer codMateria) {
        this.codMateria = codMateria;
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

    public EduDepartamento getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(EduDepartamento codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMateria != null ? codMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduMateria)) {
            return false;
        }
        EduMateria other = (EduMateria) object;
        if ((this.codMateria == null && other.codMateria != null) || (this.codMateria != null && !this.codMateria.equals(other.codMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduMateria[ codMateria=" + codMateria + " ]";
    }
    
}
