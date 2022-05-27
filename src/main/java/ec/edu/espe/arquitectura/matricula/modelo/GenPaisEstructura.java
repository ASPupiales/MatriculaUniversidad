package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gen_pais_estructura")
public class GenPaisEstructura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GenPaisEstructuraPK genPaisEstructuraPK;
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "aud_usuario")
    private String audUsuario;
    @Basic(optional = false)
    @Column(name = "aud_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Basic(optional = false)
    @Column(name = "aud_ip")
    private String audIp;
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GenPais genPais;

    public GenPaisEstructura() {
    }

    public GenPaisEstructura(GenPaisEstructuraPK genPaisEstructuraPK) {
        this.genPaisEstructuraPK = genPaisEstructuraPK;
    }

    public GenPaisEstructura(String codPais, short nivel) {
        this.genPaisEstructuraPK = new GenPaisEstructuraPK(codPais, nivel);
    }

    public GenPaisEstructuraPK getGenPaisEstructuraPK() {
        return genPaisEstructuraPK;
    }

    public void setGenPaisEstructuraPK(GenPaisEstructuraPK genPaisEstructuraPK) {
        this.genPaisEstructuraPK = genPaisEstructuraPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAudUsuario() {
        return audUsuario;
    }

    public void setAudUsuario(String audUsuario) {
        this.audUsuario = audUsuario;
    }

    public Date getAudFecha() {
        return audFecha;
    }

    public void setAudFecha(Date audFecha) {
        this.audFecha = audFecha;
    }

    public String getAudIp() {
        return audIp;
    }

    public void setAudIp(String audIp) {
        this.audIp = audIp;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public GenPais getGenPais() {
        return genPais;
    }

    public void setGenPais(GenPais genPais) {
        this.genPais = genPais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (genPaisEstructuraPK != null ? genPaisEstructuraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GenPaisEstructura)) {
            return false;
        }
        GenPaisEstructura other = (GenPaisEstructura) object;
        if ((this.genPaisEstructuraPK == null && other.genPaisEstructuraPK != null) || (this.genPaisEstructuraPK != null && !this.genPaisEstructuraPK.equals(other.genPaisEstructuraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GenPaisEstructura[ genPaisEstructuraPK=" + genPaisEstructuraPK + " ]";
    }
    
}
