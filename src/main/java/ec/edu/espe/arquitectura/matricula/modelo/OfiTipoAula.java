package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ofi_tipo_aula")
public class OfiTipoAula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cod_tipo_aula", nullable = false, length = 10)
    private String codTipoAula;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 128)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    @Basic(optional = false)
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Basic(optional = false)
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    @Basic(optional = false)
    @Column(name = "version", nullable = false)
    private int version;

    public OfiTipoAula() {
    }

    public OfiTipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    public String getCodTipoAula() {
        return codTipoAula;
    }

    public void setCodTipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoAula != null ? codTipoAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OfiTipoAula)) {
            return false;
        }
        OfiTipoAula other = (OfiTipoAula) object;
        if ((this.codTipoAula == null && other.codTipoAula != null) || (this.codTipoAula != null && !this.codTipoAula.equals(other.codTipoAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OfiTipoAula[ codTipoAula=" + codTipoAula + " ]";
    }
    
}
