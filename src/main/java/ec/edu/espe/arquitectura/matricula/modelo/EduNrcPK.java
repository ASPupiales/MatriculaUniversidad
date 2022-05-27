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
public class EduNrcPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_nrc", nullable = false)
    private short codNrc;
    @Basic(optional = false)
    @Column(name = "cod_periodo", nullable = false)
    private short codPeriodo;
    @Basic(optional = false)
    @Column(name = "cod_departamento", nullable = false)
    private int codDepartamento;
    @Basic(optional = false)
    @Column(name = "cod_materia", nullable = false)
    private int codMateria;

    public EduNrcPK() {
    }

    public EduNrcPK(short codNrc, short codPeriodo, int codDepartamento, int codMateria) {
        this.codNrc = codNrc;
        this.codPeriodo = codPeriodo;
        this.codDepartamento = codDepartamento;
        this.codMateria = codMateria;
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
        hash += (int) codNrc;
        hash += (int) codPeriodo;
        hash += (int) codDepartamento;
        hash += (int) codMateria;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduNrcPK)) {
            return false;
        }
        EduNrcPK other = (EduNrcPK) object;
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
        return "ec.edu.espe.arquitectura.matricula.modelo.EduNrcPK[ codNrc=" + codNrc + ", codPeriodo=" + codPeriodo + ", codDepartamento=" + codDepartamento + ", codMateria=" + codMateria + " ]";
    }
    
}
