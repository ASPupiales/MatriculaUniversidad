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
@Table(name = "ofi_aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OfiAula.findAll", query = "SELECT o FROM OfiAula o")})
public class OfiAula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_aula")
    private Integer codAula;
    @Basic(optional = false)
    @Column(name = "cod_alterno")
    private String codAlterno;
    @Basic(optional = false)
    @Column(name = "capacidad")
    private short capacidad;
    @Basic(optional = false)
    @Column(name = "piso")
    private short piso;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofiAula")
    private List<EduNrcHorario> eduNrcHorarioList;
    @JoinColumn(name = "cod_edificio", referencedColumnName = "cod_edificio")
    @ManyToOne
    private OfiEdificio codEdificio;
    @JoinColumn(name = "cod_edificio_bloque", referencedColumnName = "cod_edificio_bloque")
    @ManyToOne
    private OfiEdificioBloque codEdificioBloque;
    @JoinColumn(name = "cod_tipo_aula", referencedColumnName = "cod_tipo_aula")
    @ManyToOne
    private OfiTipoAula codTipoAula;

    public OfiAula() {
    }

    public OfiAula(Integer codAula) {
        this.codAula = codAula;
    }

    public OfiAula(Integer codAula, String codAlterno, short capacidad, short piso, String audUsuario, Date audFecha, String audIp, int version) {
        this.codAula = codAula;
        this.codAlterno = codAlterno;
        this.capacidad = capacidad;
        this.piso = piso;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
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

    @XmlTransient
    public List<EduNrcHorario> getEduNrcHorarioList() {
        return eduNrcHorarioList;
    }

    public void setEduNrcHorarioList(List<EduNrcHorario> eduNrcHorarioList) {
        this.eduNrcHorarioList = eduNrcHorarioList;
    }

    public OfiEdificio getCodEdificio() {
        return codEdificio;
    }

    public void setCodEdificio(OfiEdificio codEdificio) {
        this.codEdificio = codEdificio;
    }

    public OfiEdificioBloque getCodEdificioBloque() {
        return codEdificioBloque;
    }

    public void setCodEdificioBloque(OfiEdificioBloque codEdificioBloque) {
        this.codEdificioBloque = codEdificioBloque;
    }

    public OfiTipoAula getCodTipoAula() {
        return codTipoAula;
    }

    public void setCodTipoAula(OfiTipoAula codTipoAula) {
        this.codTipoAula = codTipoAula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAula != null ? codAula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfiAula)) {
            return false;
        }
        OfiAula other = (OfiAula) object;
        if ((this.codAula == null && other.codAula != null) || (this.codAula != null && !this.codAula.equals(other.codAula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.OfiAula[ codAula=" + codAula + " ]";
    }
    
}
