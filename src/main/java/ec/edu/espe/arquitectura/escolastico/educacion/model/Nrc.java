package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.persona.model.Persona;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "edu_nrc")
public class Nrc implements Serializable {

    private static final long serialVersionUID = 107L;
    @EmbeddedId
    private NrcPK pk;
    
    @Column(name = "cod_persona", nullable = false)
    private Integer codDocente;

    @Column(name = "cupo_disponible", nullable = false)
    private Integer cupoDisponible;

    @Column(name = "cupo_registrado", nullable = false)
    private Integer cupoRegistrado;

    @Column(name = "nombre", length = 255)
    private String nombre;

    @JoinColumns({
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Materia materia;

    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Periodo periodo;

    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona docente;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrc")
    private List<NrcHorario> nrcHorarios;

    public Nrc() {
    }

    public Nrc(NrcPK nrcPK) {
        this.pk = nrcPK;
    }

    public Nrc(Integer codNrc, Integer codPeriodo, Integer codDepartamento, Integer codMateria) {
        this.pk = new NrcPK(codNrc, codPeriodo, codDepartamento, codMateria);
    }

    public NrcPK getPk() {
        return pk;
    }

    public Integer getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(Integer codDocente) {
        this.codDocente = codDocente;
    }

    public void setPk(NrcPK pk) {
        this.pk = pk;
    }    

    public Integer getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(Integer cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public Integer getCupoRegistrado() {
        return cupoRegistrado;
    }

    public void setCupoRegistrado(Integer cupoRegistrado) {
        this.cupoRegistrado = cupoRegistrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Persona getDocente() {
        return docente;
    }

    public void setDocente(Persona docente) {
        this.docente = docente;
    }

    public List<NrcHorario> getNrcHorarios() {
        return nrcHorarios;
    }

    public void setNrcHorarios(List<NrcHorario> nrcHorarios) {
        this.nrcHorarios = nrcHorarios;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Nrc)) {
            return false;
        }
        Nrc other = (Nrc) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nrcPK=" + pk;
    }

}
