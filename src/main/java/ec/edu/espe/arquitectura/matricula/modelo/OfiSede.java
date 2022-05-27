package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ofi_sede")
public class OfiSede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cod_sede", nullable = false, length = 8)
    private String codSede;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 128)
    private String nombre;
    @Column(name = "direccion", length = 10)
    private String direccion;
    @Basic(optional = false)
    @Column(name = "es_principal", nullable = false, length = 1)
    private String esPrincipal;
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
    @OneToMany(mappedBy = "codSede")
    private List<OfiEdificio> ofiEdificioList;
    @JoinColumn(name = "cod_institucion", referencedColumnName = "cod_institucion")
    @ManyToOne
    private OfiInstitucion codInstitucion;

    public OfiSede() {
    }

    public OfiSede(String codSede) {
        this.codSede = codSede;
    }

    public String getCodSede() {
        return codSede;
    }

    public void setCodSede(String codSede) {
        this.codSede = codSede;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(String esPrincipal) {
        this.esPrincipal = esPrincipal;
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

    public List<OfiEdificio> getOfiEdificioList() {
        return ofiEdificioList;
    }

    public void setOfiEdificioList(List<OfiEdificio> ofiEdificioList) {
        this.ofiEdificioList = ofiEdificioList;
    }

    public OfiInstitucion getCodInstitucion() {
        return codInstitucion;
    }

    public void setCodInstitucion(OfiInstitucion codInstitucion) {
        this.codInstitucion = codInstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSede != null ? codSede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof OfiSede)) {
            return false;
        }
        OfiSede other = (OfiSede) object;
        if ((this.codSede == null && other.codSede != null) || (this.codSede != null && !this.codSede.equals(other.codSede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OfiSede[ codSede=" + codSede + " ]";
    }
    
}
