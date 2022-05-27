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
public class PerDocumentoPersonaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_persona", nullable = false)
    private int codPersona;
    @Basic(optional = false)
    @Column(name = "cod_tipo_documento", nullable = false, length = 16)
    private String codTipoDocumento;

    public PerDocumentoPersonaPK() {
    }

    public PerDocumentoPersonaPK(int codPersona, String codTipoDocumento) {
        this.codPersona = codPersona;
        this.codTipoDocumento = codTipoDocumento;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodTipoDocumento() {
        return codTipoDocumento;
    }

    public void setCodTipoDocumento(String codTipoDocumento) {
        this.codTipoDocumento = codTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codPersona;
        hash += (codTipoDocumento != null ? codTipoDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerDocumentoPersonaPK)) {
            return false;
        }
        PerDocumentoPersonaPK other = (PerDocumentoPersonaPK) object;
        if (this.codPersona != other.codPersona) {
            return false;
        }
        if ((this.codTipoDocumento == null && other.codTipoDocumento != null) || (this.codTipoDocumento != null && !this.codTipoDocumento.equals(other.codTipoDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.PerDocumentoPersonaPK[ codPersona=" + codPersona + ", codTipoDocumento=" + codTipoDocumento + " ]";
    }
    
}
