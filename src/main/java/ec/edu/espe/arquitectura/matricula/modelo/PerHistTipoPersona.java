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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "per_hist_tipo_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PerHistTipoPersona.findAll", query = "SELECT p FROM PerHistTipoPersona p")})
public class PerHistTipoPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerHistTipoPersonaPK perHistTipoPersonaPK;
    @Basic(optional = false)
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "cod_usuario_ini")
    private String codUsuarioIni;
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @Column(name = "cod_usuario_fin")
    private String codUsuarioFin;
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
    @OneToMany(mappedBy = "perHistTipoPersona")
    private List<EduInscripcionCarrera> eduInscripcionCarreraList;
    @OneToMany(mappedBy = "perHistTipoPersona")
    private List<EduAsignacionDocente> eduAsignacionDocenteList;
    @JoinColumn(name = "cod_institucion_educativa", referencedColumnName = "cod_institucion_educativa")
    @ManyToOne
    private EduInstitucionEducativa codInstitucionEducativa;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PerPersona perPersona;
    @JoinColumn(name = "cod_tipo_persona", referencedColumnName = "cod_tipo_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PerTipoPersona perTipoPersona;

    public PerHistTipoPersona() {
    }

    public PerHistTipoPersona(PerHistTipoPersonaPK perHistTipoPersonaPK) {
        this.perHistTipoPersonaPK = perHistTipoPersonaPK;
    }

    public PerHistTipoPersona(PerHistTipoPersonaPK perHistTipoPersonaPK, Date fechaInicio, String codUsuarioIni, String audUsuario, Date audFecha, String audIp, int version) {
        this.perHistTipoPersonaPK = perHistTipoPersonaPK;
        this.fechaInicio = fechaInicio;
        this.codUsuarioIni = codUsuarioIni;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public PerHistTipoPersona(int codPersona, String codTipoPersona) {
        this.perHistTipoPersonaPK = new PerHistTipoPersonaPK(codPersona, codTipoPersona);
    }

    public PerHistTipoPersonaPK getPerHistTipoPersonaPK() {
        return perHistTipoPersonaPK;
    }

    public void setPerHistTipoPersonaPK(PerHistTipoPersonaPK perHistTipoPersonaPK) {
        this.perHistTipoPersonaPK = perHistTipoPersonaPK;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCodUsuarioIni() {
        return codUsuarioIni;
    }

    public void setCodUsuarioIni(String codUsuarioIni) {
        this.codUsuarioIni = codUsuarioIni;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getCodUsuarioFin() {
        return codUsuarioFin;
    }

    public void setCodUsuarioFin(String codUsuarioFin) {
        this.codUsuarioFin = codUsuarioFin;
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
    public List<EduInscripcionCarrera> getEduInscripcionCarreraList() {
        return eduInscripcionCarreraList;
    }

    public void setEduInscripcionCarreraList(List<EduInscripcionCarrera> eduInscripcionCarreraList) {
        this.eduInscripcionCarreraList = eduInscripcionCarreraList;
    }

    @XmlTransient
    public List<EduAsignacionDocente> getEduAsignacionDocenteList() {
        return eduAsignacionDocenteList;
    }

    public void setEduAsignacionDocenteList(List<EduAsignacionDocente> eduAsignacionDocenteList) {
        this.eduAsignacionDocenteList = eduAsignacionDocenteList;
    }

    public EduInstitucionEducativa getCodInstitucionEducativa() {
        return codInstitucionEducativa;
    }

    public void setCodInstitucionEducativa(EduInstitucionEducativa codInstitucionEducativa) {
        this.codInstitucionEducativa = codInstitucionEducativa;
    }

    public PerPersona getPerPersona() {
        return perPersona;
    }

    public void setPerPersona(PerPersona perPersona) {
        this.perPersona = perPersona;
    }

    public PerTipoPersona getPerTipoPersona() {
        return perTipoPersona;
    }

    public void setPerTipoPersona(PerTipoPersona perTipoPersona) {
        this.perTipoPersona = perTipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (perHistTipoPersonaPK != null ? perHistTipoPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerHistTipoPersona)) {
            return false;
        }
        PerHistTipoPersona other = (PerHistTipoPersona) object;
        if ((this.perHistTipoPersonaPK == null && other.perHistTipoPersonaPK != null) || (this.perHistTipoPersonaPK != null && !this.perHistTipoPersonaPK.equals(other.perHistTipoPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.PerHistTipoPersona[ perHistTipoPersonaPK=" + perHistTipoPersonaPK + " ]";
    }
    
}
