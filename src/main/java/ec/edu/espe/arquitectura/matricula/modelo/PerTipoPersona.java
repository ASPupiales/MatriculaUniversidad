/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "per_tipo_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerTipoPersona.findAll", query = "SELECT p FROM PerTipoPersona p")})
public class PerTipoPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_tipo_persona")
    private String codTipoPersona;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
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
    @OneToMany(mappedBy = "codTipoPersona")
    private List<PerPersona> perPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perTipoPersona")
    private List<PerHistTipoPersona> perHistTipoPersonaList;

    public PerTipoPersona() {
    }

    public PerTipoPersona(String codTipoPersona) {
        this.codTipoPersona = codTipoPersona;
    }

    public PerTipoPersona(String codTipoPersona, String nombre, String estado, String audUsuario, Date audFecha, String audIp, int version) {
        this.codTipoPersona = codTipoPersona;
        this.nombre = nombre;
        this.estado = estado;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public String getCodTipoPersona() {
        return codTipoPersona;
    }

    public void setCodTipoPersona(String codTipoPersona) {
        this.codTipoPersona = codTipoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    @XmlTransient
    public List<PerPersona> getPerPersonaList() {
        return perPersonaList;
    }

    public void setPerPersonaList(List<PerPersona> perPersonaList) {
        this.perPersonaList = perPersonaList;
    }

    @XmlTransient
    public List<PerHistTipoPersona> getPerHistTipoPersonaList() {
        return perHistTipoPersonaList;
    }

    public void setPerHistTipoPersonaList(List<PerHistTipoPersona> perHistTipoPersonaList) {
        this.perHistTipoPersonaList = perHistTipoPersonaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoPersona != null ? codTipoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerTipoPersona)) {
            return false;
        }
        PerTipoPersona other = (PerTipoPersona) object;
        if ((this.codTipoPersona == null && other.codTipoPersona != null) || (this.codTipoPersona != null && !this.codTipoPersona.equals(other.codTipoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.PerTipoPersona[ codTipoPersona=" + codTipoPersona + " ]";
    }
    
}
