/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_institucion_educativa")
@NamedQueries({
    @NamedQuery(name = "EduInstitucionEducativa.findAll", query = "SELECT e FROM EduInstitucionEducativa e")})
public class EduInstitucionEducativa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_institucion_educativa", nullable = false)
    private Integer codInstitucionEducativa;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @Basic(optional = false)
    @Column(name = "direccion", nullable = false, length = 500)
    private String direccion;
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
    @JoinColumn(name = "cod_ubicacion_geo_int", referencedColumnName = "cod_ubicacion_geo_int", nullable = false)
    @ManyToOne(optional = false)
    private GenUbicacionGeografica codUbicacionGeoInt;

    public EduInstitucionEducativa() {
    }

    public EduInstitucionEducativa(Integer codInstitucionEducativa) {
        this.codInstitucionEducativa = codInstitucionEducativa;
    }

    public EduInstitucionEducativa(Integer codInstitucionEducativa, String nombre, String tipo, String direccion, String audUsuario, Date audFecha, String audIp, int version) {
        this.codInstitucionEducativa = codInstitucionEducativa;
        this.nombre = nombre;
        this.tipo = tipo;
        this.direccion = direccion;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public Integer getCodInstitucionEducativa() {
        return codInstitucionEducativa;
    }

    public void setCodInstitucionEducativa(Integer codInstitucionEducativa) {
        this.codInstitucionEducativa = codInstitucionEducativa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public GenUbicacionGeografica getCodUbicacionGeoInt() {
        return codUbicacionGeoInt;
    }

    public void setCodUbicacionGeoInt(GenUbicacionGeografica codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codInstitucionEducativa != null ? codInstitucionEducativa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduInstitucionEducativa)) {
            return false;
        }
        EduInstitucionEducativa other = (EduInstitucionEducativa) object;
        if ((this.codInstitucionEducativa == null && other.codInstitucionEducativa != null) || (this.codInstitucionEducativa != null && !this.codInstitucionEducativa.equals(other.codInstitucionEducativa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduInstitucionEducativa[ codInstitucionEducativa=" + codInstitucionEducativa + " ]";
    }
    
}
