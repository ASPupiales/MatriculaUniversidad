/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "seg_usuario_perfil")
@NamedQueries({
    @NamedQuery(name = "SegUsuarioPerfil.findAll", query = "SELECT s FROM SegUsuarioPerfil s")})
public class SegUsuarioPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegUsuarioPerfilPK segUsuarioPerfilPK;
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
    @JoinColumn(name = "cod_perfil", referencedColumnName = "cod_perfil", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegPerfil segPerfil;
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegUsuario segUsuario;

    public SegUsuarioPerfil() {
    }

    public SegUsuarioPerfil(SegUsuarioPerfilPK segUsuarioPerfilPK) {
        this.segUsuarioPerfilPK = segUsuarioPerfilPK;
    }

    public SegUsuarioPerfil(SegUsuarioPerfilPK segUsuarioPerfilPK, String audUsuario, Date audFecha, String audIp, int version) {
        this.segUsuarioPerfilPK = segUsuarioPerfilPK;
        this.audUsuario = audUsuario;
        this.audFecha = audFecha;
        this.audIp = audIp;
        this.version = version;
    }

    public SegUsuarioPerfil(String codUsuario, String codPerfil) {
        this.segUsuarioPerfilPK = new SegUsuarioPerfilPK(codUsuario, codPerfil);
    }

    public SegUsuarioPerfilPK getSegUsuarioPerfilPK() {
        return segUsuarioPerfilPK;
    }

    public void setSegUsuarioPerfilPK(SegUsuarioPerfilPK segUsuarioPerfilPK) {
        this.segUsuarioPerfilPK = segUsuarioPerfilPK;
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

    public SegPerfil getSegPerfil() {
        return segPerfil;
    }

    public void setSegPerfil(SegPerfil segPerfil) {
        this.segPerfil = segPerfil;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segUsuarioPerfilPK != null ? segUsuarioPerfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuarioPerfil)) {
            return false;
        }
        SegUsuarioPerfil other = (SegUsuarioPerfil) object;
        if ((this.segUsuarioPerfilPK == null && other.segUsuarioPerfilPK != null) || (this.segUsuarioPerfilPK != null && !this.segUsuarioPerfilPK.equals(other.segUsuarioPerfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.SegUsuarioPerfil[ segUsuarioPerfilPK=" + segUsuarioPerfilPK + " ]";
    }
    
}
