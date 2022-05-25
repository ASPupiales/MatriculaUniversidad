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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "seg_funcionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegFuncionalidad.findAll", query = "SELECT s FROM SegFuncionalidad s")})
public class SegFuncionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_funcionalidad")
    private Integer codFuncionalidad;
    @Basic(optional = false)
    @Column(name = "url_principal")
    private String urlPrincipal;
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
    @JoinColumn(name = "cod_modulo", referencedColumnName = "cod_modulo")
    @ManyToOne(optional = false)
    private SegModulo codModulo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segFuncionalidad")
    private List<SegPerfilFuncionalidad> segPerfilFuncionalidadList;

    public SegFuncionalidad() {
    }

    public SegFuncionalidad(Integer codFuncionalidad) {
        this.codFuncionalidad = codFuncionalidad;
    }

    public SegFuncionalidad(Integer codFuncionalidad, String urlPrincipal, String nombre, String estado, String audUsuario, Date audFecha, String audIp, int version) {
        this.codFuncionalidad = codFuncionalidad;
        this.urlPrincipal = urlPrincipal;
        this.nombre = nombre;
        this.estado = estado;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public Integer getCodFuncionalidad() {
        return codFuncionalidad;
    }

    public void setCodFuncionalidad(Integer codFuncionalidad) {
        this.codFuncionalidad = codFuncionalidad;
    }

    public String getUrlPrincipal() {
        return urlPrincipal;
    }

    public void setUrlPrincipal(String urlPrincipal) {
        this.urlPrincipal = urlPrincipal;
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

    public SegModulo getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(SegModulo codModulo) {
        this.codModulo = codModulo;
    }

    @XmlTransient
    public List<SegPerfilFuncionalidad> getSegPerfilFuncionalidadList() {
        return segPerfilFuncionalidadList;
    }

    public void setSegPerfilFuncionalidadList(List<SegPerfilFuncionalidad> segPerfilFuncionalidadList) {
        this.segPerfilFuncionalidadList = segPerfilFuncionalidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFuncionalidad != null ? codFuncionalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegFuncionalidad)) {
            return false;
        }
        SegFuncionalidad other = (SegFuncionalidad) object;
        if ((this.codFuncionalidad == null && other.codFuncionalidad != null) || (this.codFuncionalidad != null && !this.codFuncionalidad.equals(other.codFuncionalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.SegFuncionalidad[ codFuncionalidad=" + codFuncionalidad + " ]";
    }
    
}
