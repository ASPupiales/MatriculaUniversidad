package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MatriculaNrcPK implements Serializable {

    @Column(name = "cod_matricula", nullable = false, length = 10)
    private String codMatricula;

    @Column(name = "cod_persona", nullable = false)
    private Integer codPersona;

    @Column(name = "cod_nrc", nullable = false)
    private Integer codNrc;

    @Column(name = "cod_periodo", nullable = false)
    private Integer codPeriodo;

    @Column(name = "cod_departamento", nullable = false)
    private Integer codDepartamento;

    @Column(name = "cod_materia", nullable = false)
    private Integer codMateria;

    public MatriculaNrcPK() {
    }

    public MatriculaNrcPK(String codMatricula, Integer codPersona, Integer codNrc, Integer codPeriodo, Integer codDepartamento, Integer codMateria) {
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

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public Integer getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(Integer codNrc) {
        this.codNrc = codNrc;
    }

    public Integer getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(Integer codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public Integer getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(Integer codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    public Integer getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(Integer codMateria) {
        this.codMateria = codMateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMatricula != null ? codMatricula.hashCode() : 0);
        hash += (Integer) codPersona;
        hash += (Integer) codNrc;
        hash += (Integer) codPeriodo;
        hash += (Integer) codDepartamento;
        hash += (Integer) codMateria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MatriculaNrcPK)) {
            return false;
        }
        MatriculaNrcPK other = (MatriculaNrcPK) object;
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
