package ec.edu.espe.arquitectura.escolastico.orgfisico.model;

import ec.edu.espe.arquitectura.escolastico.educacion.model.NrcHorario;
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
@Table(name = "ofi_aula")
public class Aula implements Serializable {

    private static final long serialVersionUID = 117L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_aula", nullable = false)
    private Integer codAula;
    
    @Column(name = "cod_alterno", nullable = false, length = 10)
    private String codAlterno;
    
    @Column(name = "capacidad", nullable = false)
    private short capacidad;
    
    @Column(name = "piso", nullable = false)
    private short piso;
    
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    
    @Column(name = "version", nullable = false)
    private int version;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofiAula")
    private List<NrcHorario> nrcHorarios;
    
    @JoinColumn(name = "cod_edificio", referencedColumnName = "cod_edificio")
    @ManyToOne
    private Edificio edificio;
    
    @JoinColumn(name = "cod_edificio_bloque", referencedColumnName = "cod_edificio_bloque")
    @ManyToOne
    private EdificioBloque edificioBloque;
    
    @JoinColumn(name = "cod_tipo_aula", referencedColumnName = "cod_tipo_aula")
    @ManyToOne
    private TipoAula tipoAula;

    public Aula() {
    }

    public Aula(Integer codAula) {
        this.codAula = codAula;
    }

    public Integer getCodAula() {
        return codAula;
    }

    public void setCodAula(Integer codAula) {
        this.codAula = codAula;
    }

    public String getCodAlterno() {
        return codAlterno;
    }

    public void setCodAlterno(String codAlterno) {
        this.codAlterno = codAlterno;
    }

    public short getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(short capacidad) {
        this.capacidad = capacidad;
    }

    public short getPiso() {
        return piso;
    }

    public void setPiso(short piso) {
        this.piso = piso;
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

    public List<NrcHorario> getNrcHorarios() {
        return nrcHorarios;
    }

    public void setNrcHorarios(List<NrcHorario> nrcHorarios) {
        this.nrcHorarios = nrcHorarios;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public EdificioBloque getEdificioBloque() {
        return edificioBloque;
    }

    public void setEdificioBloque(EdificioBloque edificioBloque) {
        this.edificioBloque = edificioBloque;
    }

    public TipoAula getTipoAula() {
        return tipoAula;
    }

    public void setTipoAula(TipoAula tipoAula) {
        this.tipoAula = tipoAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAula != null ? codAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.codAula == null && other.codAula != null) || (this.codAula != null && !this.codAula.equals(other.codAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codAula=" + codAula;
    }
    
}
