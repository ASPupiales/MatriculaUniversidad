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

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_carrera")
@NamedQueries({
    @NamedQuery(name = "EduCarrera.findAll", query = "SELECT e FROM EduCarrera e")})
public class EduCarrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_carrera", nullable = false)
    private Integer codCarrera;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "total_semestres", nullable = false)
    private int totalSemestres;
    @Basic(optional = false)
    @Column(name = "grado", nullable = false, length = 25)
    private String grado;
    @Basic(optional = false)
    @Column(name = "perfil_profesional", nullable = false, length = 500)
    private String perfilProfesional;
    @Basic(optional = false)
    @Column(name = "nivel", nullable = false, length = 32)
    private String nivel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "total_creditos", nullable = false, precision = 5, scale = 2)
    private BigDecimal totalCreditos;
    @Basic(optional = false)
    @Column(name = "total_horas", nullable = false, precision = 5, scale = 2)
    private BigDecimal totalHoras;
    @Basic(optional = false)
    @Column(name = "siglas", nullable = false, length = 32)
    private String siglas;
    @Basic(optional = false)
    @Column(name = "precio_credito", nullable = false, precision = 5, scale = 2)
    private BigDecimal precioCredito;
    @Column(name = "modalidad", length = 64)
    private String modalidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCarrera")
    private List<EduMallaCarrera> eduMallaCarreraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCarrera")
    private List<EduMatricula> eduMatriculaList;
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false)
    @ManyToOne(optional = false)
    private EduDepartamento codDepartamento;

    public EduCarrera() {
    }

    public EduCarrera(Integer codCarrera) {
        this.codCarrera = codCarrera;
    }

    public EduCarrera(Integer codCarrera, String nombre, int totalSemestres, String grado, String perfilProfesional, String nivel, BigDecimal totalCreditos, BigDecimal totalHoras, String siglas, BigDecimal precioCredito) {
        this.codCarrera = codCarrera;
        this.nombre = nombre;
        this.totalSemestres = totalSemestres;
        this.grado = grado;
        this.perfilProfesional = perfilProfesional;
        this.nivel = nivel;
        this.totalCreditos = totalCreditos;
        this.totalHoras = totalHoras;
        this.siglas = siglas;
        this.precioCredito = precioCredito;
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

    public List<EduMallaCarrera> getEduMallaCarreraList() {
        return eduMallaCarreraList;
    }

    public void setEduMallaCarreraList(List<EduMallaCarrera> eduMallaCarreraList) {
        this.eduMallaCarreraList = eduMallaCarreraList;
    }

    public List<EduMatricula> getEduMatriculaList() {
        return eduMatriculaList;
    }

    public void setEduMatriculaList(List<EduMatricula> eduMatriculaList) {
        this.eduMatriculaList = eduMatriculaList;
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
        return "ec.edu.espe.arquitectura.matricula.modelo.EduCarrera[ codCarrera=" + codCarrera + " ]";
    }
    
}
