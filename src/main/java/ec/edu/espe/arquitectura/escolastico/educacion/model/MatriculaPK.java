package ec.edu.espe.arquitectura.escolastico.educacion.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MatriculaPK implements Serializable {

    @Column(name = "cod_matricula", nullable = false, length = 10)
    private String codMatricula;

    @Column(name = "cod_persona", nullable = false)
    private Integer codAlumno;

    public MatriculaPK() {
    }

    public MatriculaPK(String codMatricula, Integer codPersona) {
        this.codMatricula = codMatricula;
        this.codAlumno = codPersona;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public Integer getCodAlumno() {
        return codAlumno;
    }

    public void setCodAlumno(Integer codAlumno) {
        this.codAlumno = codAlumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMatricula != null ? codMatricula.hashCode() : 0);
        hash += (Integer) codAlumno;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MatriculaPK)) {
            return false;
        }
        MatriculaPK other = (MatriculaPK) object;
        if ((this.codMatricula == null && other.codMatricula != null) || (this.codMatricula != null && !this.codMatricula.equals(other.codMatricula))) {
            return false;
        }
        if (this.codAlumno != other.codAlumno) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codMatricula=" + codMatricula + ", codPersona=" + codAlumno;
    }

}
