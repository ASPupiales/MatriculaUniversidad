package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_periodo")
public class EduPeriodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cod_periodo", nullable = false)
    private Short codPeriodo;
    
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    
    @Column(name = "nivel", nullable = false, length = 32)
    private String nivel;
    
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
    @Column(name = "parciales", nullable = false)
    private short parciales;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "eduPeriodo")
    private EduNrc eduNrc;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codPeriodo")
    private EduMatricula eduMatricula;

    public EduPeriodo() {
    }

    public EduPeriodo(Short codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Short getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Short codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public short getParciales() {
        return parciales;
    }

    public void setParciales(short parciales) {
        this.parciales = parciales;
    }

    public EduNrc getEduNrc() {
        return eduNrc;
    }

    public void setEduNrc(EduNrc eduNrc) {
        this.eduNrc = eduNrc;
    }

    public EduMatricula getEduMatricula() {
        return eduMatricula;
    }

    public void setEduMatricula(EduMatricula eduMatricula) {
        this.eduMatricula = eduMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPeriodo != null ? codPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduPeriodo)) {
            return false;
        }
        EduPeriodo other = (EduPeriodo) object;
        if ((this.codPeriodo == null && other.codPeriodo != null) || (this.codPeriodo != null && !this.codPeriodo.equals(other.codPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codPeriodo=" + codPeriodo;
    }
    
}
