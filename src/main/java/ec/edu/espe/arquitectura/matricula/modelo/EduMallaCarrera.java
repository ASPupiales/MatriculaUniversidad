package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_malla_carrera")
public class EduMallaCarrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cod_materiacarrera", nullable = false)
    private Integer codMateriacarrera;
    
    @Column(name = "nivel")
    private Integer nivel;
    
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera", nullable = false)
    @ManyToOne(optional = false)
    private EduCarrera codCarrera;
    
    @JoinColumns({
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false)})
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
        return "codMateriacarrera=" + codMateriacarrera;
    }
    
}
