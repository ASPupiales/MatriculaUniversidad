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
@Table(name = "gen_pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenPais.findAll", query = "SELECT g FROM GenPais g")})
public class GenPais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_pais")
    private String codPais;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "por_omision")
    private String porOmision;
    @Column(name = "codigo_telefonico")
    private String codigoTelefonico;
    @Column(name = "nacionalidad")
    private String nacionalidad;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genPais")
    private List<GenPaisEstructura> genPaisEstructuraList;
    @OneToMany(mappedBy = "codPais")
    private List<GenUbicacionGeografica> genUbicacionGeograficaList;
    @OneToMany(mappedBy = "codPaisNacimiento")
    private List<PerPersona> perPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidad")
    private List<PerPersona> perPersonaList1;

    public GenPais() {
    }

    public GenPais(String codPais) {
        this.codPais = codPais;
    }

    public GenPais(String codPais, String nombre, String porOmision, String audUsuario, Date audFecha, String audIp, int version) {
        this.codPais = codPais;
        this.nombre = nombre;
        this.porOmision = porOmision;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorOmision() {
        return porOmision;
    }

    public void setPorOmision(String porOmision) {
        this.porOmision = porOmision;
    }

    public String getCodigoTelefonico() {
        return codigoTelefonico;
    }

    public void setCodigoTelefonico(String codigoTelefonico) {
        this.codigoTelefonico = codigoTelefonico;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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
    public List<GenPaisEstructura> getGenPaisEstructuraList() {
        return genPaisEstructuraList;
    }

    public void setGenPaisEstructuraList(List<GenPaisEstructura> genPaisEstructuraList) {
        this.genPaisEstructuraList = genPaisEstructuraList;
    }

    @XmlTransient
    public List<GenUbicacionGeografica> getGenUbicacionGeograficaList() {
        return genUbicacionGeograficaList;
    }

    public void setGenUbicacionGeograficaList(List<GenUbicacionGeografica> genUbicacionGeograficaList) {
        this.genUbicacionGeograficaList = genUbicacionGeograficaList;
    }

    @XmlTransient
    public List<PerPersona> getPerPersonaList() {
        return perPersonaList;
    }

    public void setPerPersonaList(List<PerPersona> perPersonaList) {
        this.perPersonaList = perPersonaList;
    }

    @XmlTransient
    public List<PerPersona> getPerPersonaList1() {
        return perPersonaList1;
    }

    public void setPerPersonaList1(List<PerPersona> perPersonaList1) {
        this.perPersonaList1 = perPersonaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenPais)) {
            return false;
        }
        GenPais other = (GenPais) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.GenPais[ codPais=" + codPais + " ]";
    }
    
}
