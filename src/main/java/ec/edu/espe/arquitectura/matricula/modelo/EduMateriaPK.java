/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    @Basic(optional = false)
    @Column(name = "cod_materia", nullable = false)
    private int codMateria;
    @Basic(optional = false)
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
        // TODO: Warning - this method won't work in the case the id fields are not set
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
        return "ec.edu.espe.arquitectura.matricula.modelo.EduMateriaPK[ codMateria=" + codMateria + ", codDepartamento=" + codDepartamento + " ]";
    }
    
}
