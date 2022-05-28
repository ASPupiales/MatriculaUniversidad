package ec.edu.espe.arquitectura.escolastico.orgfisico.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "ofi_tipo_aula")
public class TipoAula implements Serializable {

    private static final long serialVersionUID = 122L;
    @Id
    @Column(name = "cod_tipo_aula", nullable = false, length = 10)
    private String codTipoAula;
    
    @Column(name = "descripcion", nullable = false, length = 128)
    private String descripcion;
    
    @Column(name = "aud_usuario", nullable = false, length = 30)
    private String audUsuario;
    
    @Column(name = "aud_fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date audFecha;
    
    @Column(name = "aud_ip", nullable = false, length = 30)
    private String audIp;
    
    @Column(name = "version", nullable = false)
    private int version;
    
    @OneToMany(mappedBy = "ofiTipoAula")
    private List<Aula> aulas;

    public TipoAula() {
    }

    public TipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    public String getCodTipoAula() {
        return codTipoAula;
    }

    public void setCodTipoAula(String codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipoAula != null ? codTipoAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TipoAula)) {
            return false;
        }
        TipoAula other = (TipoAula) object;
        if ((this.codTipoAula == null && other.codTipoAula != null) || (this.codTipoAula != null && !this.codTipoAula.equals(other.codTipoAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "codTipoAula=" + codTipoAula;
    }
    
}
