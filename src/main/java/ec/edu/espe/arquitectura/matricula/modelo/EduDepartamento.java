/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "edu_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EduDepartamento.findAll", query = "SELECT e FROM EduDepartamento e")})
public class EduDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_departamento")
    private Integer codDepartamento;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "siglas")
    private String siglas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codDepartamento")
    private List<EduCarrera> eduCarreraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduDepartamento")
    private List<EduMateria> eduMateriaList;

    public EduDepartamento() {
    }

    public EduDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public EduDepartamento(Integer codDepartamento, String nombre, String descripcion, String siglas) {
        this.codDepartamento = codDepartamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.siglas = siglas;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @XmlTransient
    public List<EduCarrera> getEduCarreraList() {
        return eduCarreraList;
    }

    public void setEduCarreraList(List<EduCarrera> eduCarreraList) {
        this.eduCarreraList = eduCarreraList;
    }

    @XmlTransient
    public List<EduMateria> getEduMateriaList() {
        return eduMateriaList;
    }

    public void setEduMateriaList(List<EduMateria> eduMateriaList) {
        this.eduMateriaList = eduMateriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDepartamento != null ? codDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduDepartamento)) {
            return false;
        }
        EduDepartamento other = (EduDepartamento) object;
        if ((this.codDepartamento == null && other.codDepartamento != null) || (this.codDepartamento != null && !this.codDepartamento.equals(other.codDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduDepartamento[ codDepartamento=" + codDepartamento + " ]";
    }
    
}
