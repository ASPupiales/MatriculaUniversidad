
package ec.edu.espe.arquitectura.escolastico.general.model;

import ec.edu.espe.arquitectura.escolastico.personal.model.Persona;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "gen_ubicacion_geografica")
public class UbicacionGeografica implements Serializable {

    private static final long serialVersionUID = 116L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_ubicacion_geo_int", nullable = false)
    private Integer codUbicacionGeoInt;
    
    @Column(name = "cod_ubicacion_geografica", nullable = false, length = 20)
    private String codUbicacionGeografica;
    
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "codigo_area_telefono", length = 4)
    private String codigoAreaTelefono;
    
    @Column(name = "codigo_alterno", length = 15)
    private String codigoAlterno;
    
    @Column(name = "codigo_postal", length = 15)
    private String codigoPostal;
    
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    
    @Column(name = "version", nullable = false)
    private int version;
    
    @OneToMany(mappedBy = "genUbicacionGeografica")
    private List<InstitucionPrincipal> instituciones;
    
    @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais")
    @ManyToOne
    private Pais pais;
    
    @JoinColumns({
        @JoinColumn(name = "cod_pais", referencedColumnName = "cod_pais"),
        @JoinColumn(name = "nivel", referencedColumnName = "nivel", nullable = false)})
    @ManyToOne(optional = false)
    private PaisEstructura paisEstructura;
    
    @OneToMany(mappedBy = "ubicacionGeografica")
    private List<UbicacionGeografica> ubicacionGeograficas;
    
    @JoinColumn(name = "cod_ubicacion_geo_padre", referencedColumnName = "cod_ubicacion_geo_int")
    @ManyToOne
    private UbicacionGeografica ubicacionGeografica;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genUbicacionGeografica")
    private List<Persona> personas;

    public UbicacionGeografica() {
    }

    public UbicacionGeografica(Integer codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    public Integer getCodUbicacionGeoInt() {
        return codUbicacionGeoInt;
    }

    public void setCodUbicacionGeoInt(Integer codUbicacionGeoInt) {
        this.codUbicacionGeoInt = codUbicacionGeoInt;
    }

    public String getCodUbicacionGeografica() {
        return codUbicacionGeografica;
    }

    public void setCodUbicacionGeografica(String codUbicacionGeografica) {
        this.codUbicacionGeografica = codUbicacionGeografica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoAreaTelefono() {
        return codigoAreaTelefono;
    }

    public void setCodigoAreaTelefono(String codigoAreaTelefono) {
        this.codigoAreaTelefono = codigoAreaTelefono;
    }

    public String getCodigoAlterno() {
        return codigoAlterno;
    }

    public void setCodigoAlterno(String codigoAlterno) {
        this.codigoAlterno = codigoAlterno;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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

    public List<InstitucionPrincipal> getInstituciones() {
        return instituciones;
    }

    public void setInstituciones(List<InstitucionPrincipal> instituciones) {
        this.instituciones = instituciones;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public PaisEstructura getPaisEstructura() {
        return paisEstructura;
    }

    public void setPaisEstructura(PaisEstructura paisEstructura) {
        this.paisEstructura = paisEstructura;
    }

    public List<UbicacionGeografica> getUbicacionGeograficas() {
        return ubicacionGeograficas;
    }

    public void setUbicacionGeograficas(List<UbicacionGeografica> ubicacionGeograficas) {
        this.ubicacionGeograficas = ubicacionGeograficas;
    }

    public UbicacionGeografica getUbicacionGeografica() {
        return ubicacionGeografica;
    }

    public void setUbicacionGeografica(UbicacionGeografica ubicacionGeografica) {
        this.ubicacionGeografica = ubicacionGeografica;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUbicacionGeoInt != null ? codUbicacionGeoInt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UbicacionGeografica)) {
            return false;
        }
        UbicacionGeografica other = (UbicacionGeografica) object;
        if ((this.codUbicacionGeoInt == null && other.codUbicacionGeoInt != null) || (this.codUbicacionGeoInt != null && !this.codUbicacionGeoInt.equals(other.codUbicacionGeoInt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codUbicacionGeoInt=" + codUbicacionGeoInt;
    }
    
}
