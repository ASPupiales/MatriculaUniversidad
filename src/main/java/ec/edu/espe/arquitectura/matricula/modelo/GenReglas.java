package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gen_reglas")
public class GenReglas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cod_regla", nullable = false, length = 30)
    private String codRegla;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @Column(name = "valor_numerico")
    private Integer valorNumerico;
    @Column(name = "valor_texto", length = 50)
    private String valorTexto;
    @Basic(optional = false)
    @Column(name = "unidad", nullable = false, length = 100)
    private String unidad;
    @Basic(optional = false)
    @Column(name = "clasificacion", nullable = false, length = 3)
    private String clasificacion;
    @Column(name = "descripcion_detallada", length = 500)
    private String descripcionDetallada;
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

    public GenReglas() {
    }

    public GenReglas(String codRegla) {
        this.codRegla = codRegla;
    }

    public String getCodRegla() {
        return codRegla;
    }

    public void setCodRegla(String codRegla) {
        this.codRegla = codRegla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(Integer valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public String getValorTexto() {
        return valorTexto;
    }

    public void setValorTexto(String valorTexto) {
        this.valorTexto = valorTexto;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcionDetallada() {
        return descripcionDetallada;
    }

    public void setDescripcionDetallada(String descripcionDetallada) {
        this.descripcionDetallada = descripcionDetallada;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRegla != null ? codRegla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GenReglas)) {
            return false;
        }
        GenReglas other = (GenReglas) object;
        if ((this.codRegla == null && other.codRegla != null) || (this.codRegla != null && !this.codRegla.equals(other.codRegla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GenReglas[ codRegla=" + codRegla + " ]";
    }
    
}
