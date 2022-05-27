/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_malla_carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EduMallaCarrera.findAll", query = "SELECT e FROM EduMallaCarrera e")})
public class EduMallaCarrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_materiacarrera")
    private Integer codMateriacarrera;
    @Column(name = "nivel")
    private Integer nivel;
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera")
    @ManyToOne(optional = false)
    private EduCarrera codCarrera;
    @JoinColumns({
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia"),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento")})
    @ManyToOne(optional = false)
    private EduMateria eduMateria;

    public EduMallaCarrera() {
    }

    public EduMallaCarrera(Integer codMateriacarrera) {
        this.codMateriacarrera = codMateriacarrera;
    }

    public Integer getCodMateriacarrera() {
        return codMateriacarrera;
    }

    public void setCodMateriacarrera(Integer codMateriacarrera) {
        this.codMateriacarrera = codMateriacarrera;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public EduCarrera getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(EduCarrera codCarrera) {
        this.codCarrera = codCarrera;
    }

    public EduMateria getEduMateria() {
        return eduMateria;
    }

    public void setEduMateria(EduMateria eduMateria) {
        this.eduMateria = eduMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMateriacarrera != null ? codMateriacarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduMallaCarrera)) {
            return false;
        }
        EduMallaCarrera other = (EduMallaCarrera) object;
        if ((this.codMateriacarrera == null && other.codMateriacarrera != null) || (this.codMateriacarrera != null && !this.codMateriacarrera.equals(other.codMateriacarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduMallaCarrera[ codMateriacarrera=" + codMateriacarrera + " ]";
    }
    
}
