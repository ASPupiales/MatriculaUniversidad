package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author labox
 */
@Embeddable
public class EduMateriaPK implements Serializable {

    @Column(name = "cod_materia", nullable = false)
    private int codMateria;
    
    @Column(name = "cod_departamento", nullable = false)
    private int codDepartamento;

    public EduMateriaPK() {
    }

    public EduMateriaPK(int codMateria, int codDepartamento) {
        this.codMateria = codMateria;
        this.codDepartamento = codDepartamento;
    }

    public int getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(int codMateria) {
        this.codMateria = codMateria;
    }

    public int getCodDepartamento() {
        return codDepartamento;
    }

    public void setCodDepartamento(int codDepartamento) {
        this.codDepartamento = codDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codMateria;
        hash += (int) codDepartamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduMateriaPK)) {
            return false;
        }
        EduMateriaPK other = (EduMateriaPK) object;
        if (this.codMateria != other.codMateria) {
            return false;
        }
        if (this.codDepartamento != other.codDepartamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codMateria=" + codMateria + ", codDepartamento=" + codDepartamento;
    }
    
}
