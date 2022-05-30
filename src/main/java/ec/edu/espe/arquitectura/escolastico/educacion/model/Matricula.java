package ec.edu.espe.arquitectura.escolastico.educacion.model;

import ec.edu.espe.arquitectura.escolastico.personal.model.Persona;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "edu_matricula", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cod_periodo"})})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 105L;
    @EmbeddedId
    private MatriculaPK pk;

    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "costo", nullable = false)
    private double costo;

    @Column(name = "cod_carrera", nullable = false, insertable = false, updatable = false)
    private Integer codCarrera;
    
    @Column(name = "cod_periodo", nullable = false, insertable = false, updatable = false)
    private Integer codPeriodo;
    
    @JoinColumn(name = "cod_carrera", referencedColumnName = "cod_carrera", nullable = false)
    @ManyToOne(optional = false)
    private Carrera carrera;

    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false)
    @OneToOne(optional = false)
    private Periodo periodo;

    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private List<MatriculaNrc> matriculaNrcs;

    public Matricula() {
    }

    public Matricula(MatriculaPK matriculaPK) {
        this.pk = matriculaPK;
    }


    public Matricula(String codMatricula, int codPersona) {
        this.pk = new MatriculaPK(codMatricula, codPersona);
    }

    public MatriculaPK getPk() {
        return pk;
    }

    public void setPk(MatriculaPK pk) {
        this.pk = pk;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Integer getCodCarrera() {
        return codCarrera;
    }

    public void setCodCarrera(Integer codCarrera) {
        this.codCarrera = codCarrera;
    }

    public Integer getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Integer codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<MatriculaNrc> getMatriculaNrcs() {
        return matriculaNrcs;
    }

    public void setMatriculaNrcs(List<MatriculaNrc> matriculaNrcs) {
        this.matriculaNrcs = matriculaNrcs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "matriculaPK=" + pk;
    }

}
