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
@Table(name = "edu_inscripcion_carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EduInscripcionCarrera.findAll", query = "SELECT e FROM EduInscripcionCarrera e")})
public class EduInscripcionCarrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_inscripcion_carrera")
    private Integer codInscripcionCarrera;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codInscripcionEstudiante")
    private List<EduMatricula> eduMatriculaList;
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera")
    @ManyToOne(optional = false)
    private EduCarrera codCarrera;
    @JoinColumns({
        @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona"),
        @JoinColumn(name = "cod_tipo_persona", referencedColumnName = "cod_tipo_persona")})
    @ManyToOne
    private PerHistTipoPersona perHistTipoPersona;

    public EduInscripcionCarrera() {
    }

    public EduInscripcionCarrera(Integer codInscripcionCarrera) {
        this.codInscripcionCarrera = codInscripcionCarrera;
    }

    public EduInscripcionCarrera(Integer codInscripcionCarrera, Date fecha, String estado) {
        this.codInscripcionCarrera = codInscripcionCarrera;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getCodInscripcionCarrera() {
        return codInscripcionCarrera;
    }

    public void setCodInscripcionCarrera(Integer codInscripcionCarrera) {
        this.codInscripcionCarrera = codInscripcionCarrera;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<EduMatricula> getEduMatriculaList() {
        return eduMatriculaList;
    }

    public void setEduMatriculaList(List<EduMatricula> eduMatriculaList) {
        this.eduMatriculaList = eduMatriculaList;
    }

    public EduCarrera getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(EduCarrera codCarrera) {
        this.codCarrera = codCarrera;
    }

    public PerHistTipoPersona getPerHistTipoPersona() {
        return perHistTipoPersona;
    }

    public void setPerHistTipoPersona(PerHistTipoPersona perHistTipoPersona) {
        this.perHistTipoPersona = perHistTipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInscripcionCarrera != null ? codInscripcionCarrera.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduInscripcionCarrera)) {
            return false;
        }
        EduInscripcionCarrera other = (EduInscripcionCarrera) object;
        if ((this.codInscripcionCarrera == null && other.codInscripcionCarrera != null) || (this.codInscripcionCarrera != null && !this.codInscripcionCarrera.equals(other.codInscripcionCarrera))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduInscripcionCarrera[ codInscripcionCarrera=" + codInscripcionCarrera + " ]";
    }
    
}
