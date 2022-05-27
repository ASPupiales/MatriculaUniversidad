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
@Table(name = "per_direccion_persona")
@XmlRootElement

public class PerDireccionPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerDireccionPersonaPK perDireccionPersonaPK;
    @Column(name = "cod_tipo_direccion")
    private String codTipoDireccion;
    @Column(name = "cod_org_geo_direccion")
    private int codOrgGeoDireccion;
    @Column(name = "calle_principal")
    private String callePrincipal;
    @Column(name = "numeracion")
    private String numeracion;
    @Column(name = "calle_secundaria")
    private String calleSecundaria;
    @Column(name = "direccion_adicional")
    private String direccionAdicional;
    @Column(name = "barrio")
    private String barrio;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "principal")
    private String principal;
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
    @ManyToOne(optional = false)
    private PerPersona perPersona;

    public PerDireccionPersona() {
    }

    public PerDireccionPersona(PerDireccionPersonaPK perDireccionPersonaPK) {
        this.perDireccionPersonaPK = perDireccionPersonaPK;
    }

    public PerDireccionPersona(int codPersona, short secDireccion) {
        this.perDireccionPersonaPK = new PerDireccionPersonaPK(codPersona, secDireccion);
    }

    public PerDireccionPersonaPK getPerDireccionPersonaPK() {
        return perDireccionPersonaPK;
    }

    public void setPerDireccionPersonaPK(PerDireccionPersonaPK perDireccionPersonaPK) {
        this.perDireccionPersonaPK = perDireccionPersonaPK;
    }

    public String getCodTipoDireccion() {
        return codTipoDireccion;
    }

    public void setCodTipoDireccion(String codTipoDireccion) {
        this.codTipoDireccion = codTipoDireccion;
    }

    public int getCodOrgGeoDireccion() {
        return codOrgGeoDireccion;
    }

    public void setCodOrgGeoDireccion(int codOrgGeoDireccion) {
        this.codOrgGeoDireccion = codOrgGeoDireccion;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getNumeracion() {
        return numeracion;
    }

    public void setNumeracion(String numeracion) {
        this.numeracion = numeracion;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getDireccionAdicional() {
        return direccionAdicional;
    }

    public void setDireccionAdicional(String direccionAdicional) {
        this.direccionAdicional = direccionAdicional;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perDireccionPersonaPK != null ? perDireccionPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerDireccionPersona)) {
            return false;
        }
        PerDireccionPersona other = (PerDireccionPersona) object;
        if ((this.perDireccionPersonaPK == null && other.perDireccionPersonaPK != null) || (this.perDireccionPersonaPK != null && !this.perDireccionPersonaPK.equals(other.perDireccionPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.PerDireccionPersona[ perDireccionPersonaPK=" + perDireccionPersonaPK + " ]";
    }
    
}
