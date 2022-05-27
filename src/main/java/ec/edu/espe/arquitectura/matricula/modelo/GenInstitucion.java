package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gen_institucion")
public class GenInstitucion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ruc")
    private String ruc;
    @Basic(optional = false)
    @Column(name = "razon_social")
    private String razonSocial;
    @Basic(optional = false)
    @Column(name = "nombre_comercial")
    private String nombreComercial;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "dominio")
    private String dominio;
    @Column(name = "url_info")
    private String urlInfo;
    @Basic(optional = false)
    @Column(name = "url_sistema")
    private String urlSistema;
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    @JoinColumn(name = "cod_ubicacion_geo_int", referencedColumnName = "cod_ubicacion_geo_int")
    @ManyToOne
    private GenUbicacionGeografica codUbicacionGeoInt;

    public GenInstitucion() {
    }

    public GenInstitucion(String ruc) {
        this.ruc = ruc;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getUrlInfo() {
        return urlInfo;
    }

    public void setUrlInfo(String urlInfo) {
        this.urlInfo = urlInfo;
    }

    public String getUrlSistema() {
        return urlSistema;
    }

    public void setUrlSistema(String urlSistema) {
        this.urlSistema = urlSistema;
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
        hash += (ruc != null ? ruc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GenInstitucion)) {
            return false;
        }
        GenInstitucion other = (GenInstitucion) object;
        if ((this.ruc == null && other.ruc != null) || (this.ruc != null && !this.ruc.equals(other.ruc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GenInstitucion[ ruc=" + ruc + " ]";
    }
    
}
