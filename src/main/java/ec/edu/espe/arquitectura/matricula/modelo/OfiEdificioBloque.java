/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Table(name = "ofi_edificio_bloque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfiEdificioBloque.findAll", query = "SELECT o FROM OfiEdificioBloque o")})
public class OfiEdificioBloque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_edificio_bloque")
    private String codEdificioBloque;
    @Basic(optional = false)
    @Column(name = "nombre_bloque")
    private String nombreBloque;
    @Column(name = "descripcion")
    private String descripcion;
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
    @JoinColumn(name = "cod_edificio", referencedColumnName = "cod_edificio")
    @ManyToOne
    private OfiEdificio codEdificio;
    @OneToMany(mappedBy = "codEdificioBloque")
    private List<OfiAula> ofiAulaList;

    public OfiEdificioBloque() {
    }

    public OfiEdificioBloque(String codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    public OfiEdificioBloque(String codEdificioBloque, String nombreBloque, String audUsuario, Date audFecha, String audIp, int version) {
        this.codEdificioBloque = codEdificioBloque;
        this.nombreBloque = nombreBloque;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public String getCodEdificioBloque() {
        return codEdificioBloque;
    }

    public void setCodEdificioBloque(String codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    public String getNombreBloque() {
        return nombreBloque;
    }

    public void setNombreBloque(String nombreBloque) {
        this.nombreBloque = nombreBloque;
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

    public OfiEdificio getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(OfiEdificio codEdificio) {
        this.codEdificio = codEdificio;
    }

    @XmlTransient
    public List<OfiAula> getOfiAulaList() {
        return ofiAulaList;
    }

    public void setOfiAulaList(List<OfiAula> ofiAulaList) {
        this.ofiAulaList = ofiAulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEdificioBloque != null ? codEdificioBloque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfiEdificioBloque)) {
            return false;
        }
        OfiEdificioBloque other = (OfiEdificioBloque) object;
        if ((this.codEdificioBloque == null && other.codEdificioBloque != null) || (this.codEdificioBloque != null && !this.codEdificioBloque.equals(other.codEdificioBloque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.OfiEdificioBloque[ codEdificioBloque=" + codEdificioBloque + " ]";
    }
    
}
