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
@Table(name = "per_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerPersona.findAll", query = "SELECT p FROM PerPersona p")})
public class PerPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_persona")
    private Integer codPersona;
    @Basic(optional = false)
    @Column(name = "codigo_alterno")
    private String codigoAlterno;
    @Basic(optional = false)
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @Column(name = "nombre1")
    private String nombre1;
    @Column(name = "nombre2")
    private String nombre2;
    @Basic(optional = false)
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Basic(optional = false)
    @Column(name = "nombre_completo")
    private String nombreCompleto;
    @Column(name = "nombre_comun")
    private String nombreComun;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Column(name = "email_alterno")
    private String emailAlterno;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Column(name = "telefono_movil")
    private String telefonoMovil;
    @Basic(optional = false)
    @Column(name = "extranjero")
    private String extranjero;
    @Basic(optional = false)
    @Column(name = "requiere_representante")
    private String requiereRepresentante;
    @Basic(optional = false)
    @Column(name = "discapacidad")
    private String discapacidad;
    @Column(name = "porcentaje_discapacidad")
    private Short porcentajeDiscapacidad;
    @Column(name = "carnet_conadis")
    private String carnetConadis;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perPersona")
    private List<PerDireccionPersona> perDireccionPersonaList;
    @JoinColumn(name = "cod_pais_nacimiento", referencedColumnName = "cod_pais")
    @ManyToOne
    private GenPais codPaisNacimiento;
    @JoinColumn(name = "nacionalidad", referencedColumnName = "cod_pais")
    @ManyToOne(optional = false)
    private GenPais nacionalidad;
    @JoinColumn(name = "lugar_nacimiento", referencedColumnName = "cod_ubicacion_geo_int")
    @ManyToOne(optional = false)
    private GenUbicacionGeografica lugarNacimiento;
    @JoinColumn(name = "cod_tipo_discapacidad", referencedColumnName = "cod_tipo_discapacidad")
    @ManyToOne
    private PerTipoDiscapacidad codTipoDiscapacidad;
    @JoinColumn(name = "cod_tipo_persona", referencedColumnName = "cod_tipo_persona")
    @ManyToOne
    private PerTipoPersona codTipoPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perPersona")
    private List<PerDocumentoPersona> perDocumentoPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perPersona")
    private List<PerFamiliarPersona> perFamiliarPersonaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "perPersona")
    private List<PerHistTipoPersona> perHistTipoPersonaList;

    public PerPersona() {
    }

    public PerPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public PerPersona(Integer codPersona, String codigoAlterno, String tipoIdentificacion, String identificacion, String nombre1, String apellido1, String nombreCompleto, String genero, Date fechaNacimiento, String estadoCivil, String email, String estado, String extranjero, String requiereRepresentante, String discapacidad, String audUsuario, Date audFecha, String audIp, int version) {
        this.codPersona = codPersona;
        this.codigoAlterno = codigoAlterno;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.nombre1 = nombre1;
        this.apellido1 = apellido1;
        this.nombreCompleto = nombreCompleto;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.email = email;
        this.estado = estado;
        this.extranjero = extranjero;
        this.requiereRepresentante = requiereRepresentante;
        this.discapacidad = discapacidad;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public Integer getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(Integer codPersona) {
        this.codPersona = codPersona;
    }

    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
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

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailAlterno() {
        return emailAlterno;
    }

    public void setEmailAlterno(String emailAlterno) {
        this.emailAlterno = emailAlterno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public String getExtranjero() {
        return extranjero;
    }

    public void setExtranjero(String extranjero) {
        this.extranjero = extranjero;
    }

    public String getRequiereRepresentante() {
        return requiereRepresentante;
    }

    public void setRequiereRepresentante(String requiereRepresentante) {
        this.requiereRepresentante = requiereRepresentante;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public Short getPorcentajeDiscapacidad() {
        return porcentajeDiscapacidad;
    }

    public void setPorcentajeDiscapacidad(Short porcentajeDiscapacidad) {
        this.porcentajeDiscapacidad = porcentajeDiscapacidad;
    }

    public String getCarnetConadis() {
        return carnetConadis;
    }

    public void setCarnetConadis(String carnetConadis) {
        this.carnetConadis = carnetConadis;
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
    public List<PerDireccionPersona> getPerDireccionPersonaList() {
        return perDireccionPersonaList;
    }

    public void setPerDireccionPersonaList(List<PerDireccionPersona> perDireccionPersonaList) {
        this.perDireccionPersonaList = perDireccionPersonaList;
    }

    public GenPais getCodPaisNacimiento() {
        return codPaisNacimiento;
    }

    public void setCodPaisNacimiento(GenPais codPaisNacimiento) {
        this.codPaisNacimiento = codPaisNacimiento;
    }

    public GenPais getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(GenPais nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public GenUbicacionGeografica getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(GenUbicacionGeografica lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public PerTipoDiscapacidad getCodTipoDiscapacidad() {
        return codTipoDiscapacidad;
    }

    public void setCodTipoDiscapacidad(PerTipoDiscapacidad codTipoDiscapacidad) {
        this.codTipoDiscapacidad = codTipoDiscapacidad;
    }

    public PerTipoPersona getCodTipoPersona() {
        return codTipoPersona;
    }

    public void setCodTipoPersona(PerTipoPersona codTipoPersona) {
        this.codTipoPersona = codTipoPersona;
    }

    @XmlTransient
    public List<PerDocumentoPersona> getPerDocumentoPersonaList() {
        return perDocumentoPersonaList;
    }

    public void setPerDocumentoPersonaList(List<PerDocumentoPersona> perDocumentoPersonaList) {
        this.perDocumentoPersonaList = perDocumentoPersonaList;
    }

    @XmlTransient
    public List<PerFamiliarPersona> getPerFamiliarPersonaList() {
        return perFamiliarPersonaList;
    }

    public void setPerFamiliarPersonaList(List<PerFamiliarPersona> perFamiliarPersonaList) {
        this.perFamiliarPersonaList = perFamiliarPersonaList;
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
        hash += (codPersona != null ? codPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerPersona)) {
            return false;
        }
        PerPersona other = (PerPersona) object;
        if ((this.codPersona == null && other.codPersona != null) || (this.codPersona != null && !this.codPersona.equals(other.codPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.PerPersona[ codPersona=" + codPersona + " ]";
    }
    
}
