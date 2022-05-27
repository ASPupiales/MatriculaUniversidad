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
public class EduCalificacionPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_matricula")
    private String codMatricula;
    @Basic(optional = false)
    @Column(name = "cod_persona")
    private int codPersona;
    @Basic(optional = false)
    @Column(name = "cod_nrc")
    private short codNrc;

    public EduCalificacionPK() {
    }

    public EduCalificacionPK(String codMatricula, int codPersona, short codNrc) {
        this.codMatricula = codMatricula;
        this.codPersona = codPersona;
        this.codNrc = codNrc;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMatricula != null ? codMatricula.hashCode() : 0);
        hash += (int) codPersona;
        hash += (int) codNrc;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduCalificacionPK)) {
            return false;
        }
        EduCalificacionPK other = (EduCalificacionPK) object;
        if ((this.codMatricula == null && other.codMatricula != null) || (this.codMatricula != null && !this.codMatricula.equals(other.codMatricula))) {
            return false;
        }
        if (this.codPersona != other.codPersona) {
            return false;
        }
        if (this.codNrc != other.codNrc) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduCalificacionPK[ codMatricula=" + codMatricula + ", codPersona=" + codPersona + ", codNrc=" + codNrc + " ]";
    }
    
}
