package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GenPaisEstructuraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "cod_pais", nullable = false, length = 2)
    private String codPais;
    @Basic(optional = false)
    @Column(name = "nivel", nullable = false)
    private short nivel;

    public GenPaisEstructuraPK() {
    }

    public GenPaisEstructuraPK(String codPais, short nivel) {
        this.codPais = codPais;
        this.nivel = nivel;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public short getNivel() {
        return nivel;
    }

    public void setNivel(short nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        hash += (int) nivel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GenPaisEstructuraPK)) {
            return false;
        }
        GenPaisEstructuraPK other = (GenPaisEstructuraPK) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GenPaisEstructuraPK[ codPais=" + codPais + ", nivel=" + nivel + " ]";
    }
    
}
