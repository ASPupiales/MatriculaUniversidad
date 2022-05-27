package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author labox
 */
@Embeddable
public class EduMatriculaNrcPK implements Serializable {

    @Column(name = "cod_matricula", nullable = false, length = 10)
    private String codMatricula;
    
    @Column(name = "cod_persona", nullable = false)
    private int codPersona;
    
    @Column(name = "cod_nrc", nullable = false)
    private short codNrc;
    
    @Column(name = "cod_periodo", nullable = false)
    private short codPeriodo;
    
    @Column(name = "cod_departamento", nullable = false)
    private int codDepartamento;
    
    @Column(name = "cod_materia", nullable = false)
    private int codMateria;
    
    public EduMatriculaNrcPK() {
    }

    public EduMatriculaNrcPK(String codMatricula, int codPersona, short codNrc, short codPeriodo, int codDepartamento, int codMateria) {
        this.codMatricula = codMatricula;
        this.codPersona = codPersona;
        this.codNrc = codNrc;
        this.codPeriodo = codPeriodo;
        this.codDepartamento = codDepartamento;
        this.codMateria = codMateria;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public short getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(short codNrc) {
        this.codNrc = codNrc;
    }

    public short getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(short codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public int getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(int codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public int getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMatricula != null ? codMatricula.hashCode() : 0);
        hash += (int) codPersona;
        hash += (int) codNrc;
        hash += (int) codPeriodo;
        hash += (int) codDepartamento;
        hash += (int) codMateria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduMatriculaNrcPK)) {
            return false;
        }
        EduMatriculaNrcPK other = (EduMatriculaNrcPK) object;
        if ((this.codMatricula == null && other.codMatricula != null) || (this.codMatricula != null && !this.codMatricula.equals(other.codMatricula))) {
            return false;
        }
        if (this.codPersona != other.codPersona) {
            return false;
        }
        if (this.codNrc != other.codNrc) {
            return false;
        }
        if (this.codPeriodo != other.codPeriodo) {
            return false;
        }
        if (this.codDepartamento != other.codDepartamento) {
            return false;
        }
        if (this.codMateria != other.codMateria) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codMatricula=" + codMatricula + ", codPersona=" + codPersona + ", codNrc=" + codNrc + ", codPeriodo=" + codPeriodo + ", codDepartamento=" + codDepartamento + ", codMateria=" + codMateria;
    }
    
}
