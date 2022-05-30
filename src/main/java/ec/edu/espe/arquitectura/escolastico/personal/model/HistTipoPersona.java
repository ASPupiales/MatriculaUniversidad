package ec.edu.espe.arquitectura.escolastico.personal.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "per_hist_tipo_persona")
public class HistTipoPersona implements Serializable {

    private static final long serialVersionUID = 126L;
    @EmbeddedId
    private HistTipoPersonaPK pk;
    
    @Column(name = "cod_persona", nullable = false, insertable = false, updatable = false)
    private int codPersona;

    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Column(name = "cod_usuario_ini", nullable = false, length = 30)
    private String codUsuarioIni;

    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    @Column(name = "cod_usuario_fin", length = 30)
    private String codUsuarioFin;

    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;

    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;

    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;

    @Column(name = "version", nullable = false)
    private int version;

    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    @JoinColumn(name = "cod_tipo_persona", referencedColumnName = "cod_tipo_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TipoPersona tipoPersona;

    public HistTipoPersona() {
    }

    public HistTipoPersona(HistTipoPersonaPK perHistTipoPersonaPK) {
        this.pk = perHistTipoPersonaPK;
    }

    public HistTipoPersona(int codPersona, String codTipoPersona) {
        this.pk = new HistTipoPersonaPK(codPersona, codTipoPersona);
    }

    public HistTipoPersonaPK getPk() {
        return pk;
    }

    public void setPk(HistTipoPersonaPK pk) {
        this.pk = pk;
    }

    public int getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(int codPersona) {
        this.codPersona = codPersona;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCodUsuarioIni() {
        return codUsuarioIni;
    }

    public void setCodUsuarioIni(String codUsuarioIni) {
        this.codUsuarioIni = codUsuarioIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodUsuarioFin() {
        return codUsuarioFin;
    }

    public void setCodUsuarioFin(String codUsuarioFin) {
        this.codUsuarioFin = codUsuarioFin;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pk != null ? pk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof HistTipoPersona)) {
            return false;
        }
        HistTipoPersona other = (HistTipoPersona) object;
        if ((this.pk == null && other.pk != null) || (this.pk != null && !this.pk.equals(other.pk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "perHistTipoPersonaPK=" + pk;
    }

}
