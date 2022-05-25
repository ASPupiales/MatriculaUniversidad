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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_carrera")
public class EduCarrera implements Serializable {

    private static final long serialVersionUID = 123L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_carrera")
    private Integer codCarrera;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "total_semestres")
    private int totalSemestres;
    
    @Basic(optional = false)
    @Column(name = "grado")
    private String grado;
    
    @Basic(optional = false)
    @Column(name = "perfil_profesional")
    private String perfilProfesional;
    
    @Basic(optional = false)
    @Column(name = "nivel")
    private String nivel;
    
    @Basic(optional = false)
    @Column(name = "total_creditos")
    private BigDecimal totalCreditos;
    
    @Basic(optional = false)
    @Column(name = "total_horas")
    private BigDecimal totalHoras;
    
    @Basic(optional = false)
    @Column(name = "siglas")
    private String siglas;
    
    @Basic(optional = false)
    @Column(name = "precio_credito")
    private BigDecimal precioCredito;
    
    @Column(name = "modalidad")
    private String modalidad;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCarrera")
    private List<EduMallaCarrera> eduMallaCarreraList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCarrera")
    private List<EduInscripcionCarrera> eduInscripcionCarreraList;
    
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento")
    @ManyToOne(optional = false)
    private EduDepartamento codDepartamento;

    public EduCarrera() {
    }

    public EduCarrera(Integer codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Integer getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Integer codCarrera) {
        this.codCarrera = codCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalSemestres() {
        return totalSemestres;
    }

    public void setTotalSemestres(int totalSemestres) {
        this.totalSemestres = totalSemestres;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getPerfilProfesional() {
        return perfilProfesional;
    }

    public void setPerfilProfesional(String perfilProfesional) {
        this.perfilProfesional = perfilProfesional;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public BigDecimal getTotalCreditos() {
        return totalCreditos;
    }

    public void setTotalCreditos(BigDecimal totalCreditos) {
        this.totalCreditos = totalCreditos;
    }

    public BigDecimal getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(BigDecimal totalHoras) {
        this.totalHoras = totalHoras;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public BigDecimal getPrecioCredito() {
        return precioCredito;
    }

    public void setPrecioCredito(BigDecimal precioCredito) {
        this.precioCredito = precioCredito;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    @XmlTransient
    public List<EduMallaCarrera> getEduMallaCarreraList() {
        return eduMallaCarreraList;
    }

    public void setEduMallaCarreraList(List<EduMallaCarrera> eduMallaCarreraList) {
        this.eduMallaCarreraList = eduMallaCarreraList;
    }

    @XmlTransient
    public List<EduInscripcionCarrera> getEduInscripcionCarreraList() {
        return eduInscripcionCarreraList;
    }

    public void setEduInscripcionCarreraList(List<EduInscripcionCarrera> eduInscripcionCarreraList) {
        this.eduInscripcionCarreraList = eduInscripcionCarreraList;
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
        hash += (codCarrera != null ? codCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduCarrera)) {
            return false;
        }
        EduCarrera other = (EduCarrera) object;
        if ((this.codCarrera == null && other.codCarrera != null) || (this.codCarrera != null && !this.codCarrera.equals(other.codCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codCarrera=" + codCarrera;
    }
    
}
