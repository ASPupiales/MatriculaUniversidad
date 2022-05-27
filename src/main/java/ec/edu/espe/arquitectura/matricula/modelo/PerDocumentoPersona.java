/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "per_documento_persona")
@XmlRootElement
public class PerDocumentoPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerDocumentoPersonaPK perDocumentoPersonaPK;
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "archivado")
    private String archivado;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fecha_caducidad")
    @Temporal(TemporalType.DATE)
    private Date fechaCaducidad;
    @Column(name = "digitalizado")
    private String digitalizado;
    @Column(name = "url")
    private String url;
    @Column(name = "aud_usuario")
    private String audUsuario;
    @Column(name = "aud_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    @Column(name = "aud_ip")
    private String audIp;
    @Column(name = "version")
    private int version;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", insertable = false, updatable = false)
    private PerPersona perPersona;
    @JoinColumn(name = "cod_tipo_documento", referencedColumnName = "cod_tipo_documento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PerTipoDocumento perTipoDocumento;

    public PerDocumentoPersona() {
    }

    public PerDocumentoPersona(PerDocumentoPersonaPK perDocumentoPersonaPK) {
        this.perDocumentoPersonaPK = perDocumentoPersonaPK;
    }

    public PerDocumentoPersona(PerDocumentoPersonaPK perDocumentoPersonaPK, String estado, Date fechaRegistro, String audUsuario, Date audFecha, String audIp, int version) {
        this.perDocumentoPersonaPK = perDocumentoPersonaPK;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public PerDocumentoPersona(int codPersona, String codTipoDocumento) {
        this.perDocumentoPersonaPK = new PerDocumentoPersonaPK(codPersona, codTipoDocumento);
    }

    public PerDocumentoPersonaPK getPerDocumentoPersonaPK() {
        return perDocumentoPersonaPK;
    }

    public void setPerDocumentoPersonaPK(PerDocumentoPersonaPK perDocumentoPersonaPK) {
        this.perDocumentoPersonaPK = perDocumentoPersonaPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getArchivado() {
        return archivado;
    }

    public void setArchivado(String archivado) {
        this.archivado = archivado;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public String getDigitalizado() {
        return digitalizado;
    }

    public void setDigitalizado(String digitalizado) {
        this.digitalizado = digitalizado;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public PerPersona getPerPersona() {
        return perPersona;
    }

    public void setPerPersona(PerPersona perPersona) {
        this.perPersona = perPersona;
    }

    public PerTipoDocumento getPerTipoDocumento() {
        return perTipoDocumento;
    }

    public void setPerTipoDocumento(PerTipoDocumento perTipoDocumento) {
        this.perTipoDocumento = perTipoDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perDocumentoPersonaPK != null ? perDocumentoPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerDocumentoPersona)) {
            return false;
        }
        PerDocumentoPersona other = (PerDocumentoPersona) object;
        if ((this.perDocumentoPersonaPK == null && other.perDocumentoPersonaPK != null) || (this.perDocumentoPersonaPK != null && !this.perDocumentoPersonaPK.equals(other.perDocumentoPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.PerDocumentoPersona[ perDocumentoPersonaPK=" + perDocumentoPersonaPK + " ]";
    }
    
}
