package ec.edu.espe.arquitectura.escolastico.general.model;

import ec.edu.espe.arquitectura.escolastico.personal.model.Persona;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gen_pais")
public class Pais implements Serializable {

    private static final long serialVersionUID = 113L;
    @Id
    @Column(name = "cod_pais", nullable = false, length = 2)
    private String codPais;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "por_omision", nullable = false, length = 1)
    private String porOmision;

    @Column(name = "codigo_telefonico", length = 3)
    private String codigoTelefonico;

    @Column(name = "nacionalidad", length = 50)
    private String nacionalidad;

    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;

    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;

    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;

    @Column(name = "version", nullable = false)
    private int version;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private List<PaisEstructura> paisesEstructura;

    @OneToMany(mappedBy = "pais")
    private List<UbicacionGeografica> ubicacionesGeograficas;
  
    @OneToMany(mappedBy = "paisNacimiento")
    private List<Persona> personas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nacionalidad")
    private List<Persona> personas1;

    public Pais() {
    }

    public Pais(String codPais) {
        this.codPais = codPais;
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

    public List<PaisEstructura> getPaisesEstructura() {
        return paisesEstructura;
    }

    public void setPaisesEstructura(List<PaisEstructura> paisesEstructura) {
        this.paisesEstructura = paisesEstructura;
    }

    public List<UbicacionGeografica> getUbicacionesGeograficas() {
        return ubicacionesGeograficas;
    }

    public void setUbicacionesGeograficas(List<UbicacionGeografica> ubicacionesGeograficas) {
        this.ubicacionesGeograficas = ubicacionesGeograficas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPais != null ? codPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.codPais == null && other.codPais != null) || (this.codPais != null && !this.codPais.equals(other.codPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codPais=" + codPais;
    }

}
