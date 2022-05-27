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
@Table(name = "per_familiar_persona")
@XmlRootElement

public class PerFamiliarPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerFamiliarPersonaPK perFamiliarPersonaPK;
    @Column(name = "tipo_familiar")
    private String tipoFamiliar;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Column(name = "identificacion")
    private String identificacion;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "telefono")
    private String telefono;
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

    public PerFamiliarPersona() {
    }

    public PerFamiliarPersona(PerFamiliarPersonaPK perFamiliarPersonaPK) {
        this.perFamiliarPersonaPK = perFamiliarPersonaPK;
    }

    public PerFamiliarPersona(int codPersona, short secFamiliarPersona) {
        this.perFamiliarPersonaPK = new PerFamiliarPersonaPK(codPersona, secFamiliarPersona);
    }

    public PerFamiliarPersonaPK getPerFamiliarPersonaPK() {
        return perFamiliarPersonaPK;
    }

    public void setPerFamiliarPersonaPK(PerFamiliarPersonaPK perFamiliarPersonaPK) {
        this.perFamiliarPersonaPK = perFamiliarPersonaPK;
    }

    public String getTipoFamiliar() {
        return tipoFamiliar;
    }

    public void setTipoFamiliar(String tipoFamiliar) {
        this.tipoFamiliar = tipoFamiliar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (perFamiliarPersonaPK != null ? perFamiliarPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerFamiliarPersona)) {
            return false;
        }
        PerFamiliarPersona other = (PerFamiliarPersona) object;
        if ((this.perFamiliarPersonaPK == null && other.perFamiliarPersonaPK != null) || (this.perFamiliarPersonaPK != null && !this.perFamiliarPersonaPK.equals(other.perFamiliarPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.PerFamiliarPersona[ perFamiliarPersonaPK=" + perFamiliarPersonaPK + " ]";
    }
    
}
