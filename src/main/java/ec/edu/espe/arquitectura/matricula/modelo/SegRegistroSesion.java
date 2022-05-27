/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "seg_registro_sesion")
@NamedQueries({
    @NamedQuery(name = "SegRegistroSesion.findAll", query = "SELECT s FROM SegRegistroSesion s")})
public class SegRegistroSesion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "secuencia", nullable = false)
    private Integer secuencia;
    @Basic(optional = false)
    @Column(name = "cod_usuario", nullable = false, length = 32)
    private String codUsuario;
    @Basic(optional = false)
    @Column(name = "fecha_conexion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaConexion;
    @Basic(optional = false)
    @Column(name = "ip_conexion", nullable = false, length = 30)
    private String ipConexion;
    @Basic(optional = false)
    @Column(name = "resultado", nullable = false, length = 3)
    private String resultado;
    @Column(name = "error", length = 5)
    private String error;

    public SegRegistroSesion() {
    }

    public SegRegistroSesion(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public SegRegistroSesion(Integer secuencia, String codUsuario, Date fechaConexion, String ipConexion, String resultado) {
        this.secuencia = secuencia;
        this.codUsuario = codUsuario;
        this.fechaConexion = fechaConexion;
        this.ipConexion = ipConexion;
        this.resultado = resultado;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Date getFechaConexion() {
        return fechaConexion;
    }

    public void setFechaConexion(Date fechaConexion) {
        this.fechaConexion = fechaConexion;
    }

    public String getIpConexion() {
        return ipConexion;
    }

    public void setIpConexion(String ipConexion) {
        this.ipConexion = ipConexion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secuencia != null ? secuencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRegistroSesion)) {
            return false;
        }
        SegRegistroSesion other = (SegRegistroSesion) object;
        if ((this.secuencia == null && other.secuencia != null) || (this.secuencia != null && !this.secuencia.equals(other.secuencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.SegRegistroSesion[ secuencia=" + secuencia + " ]";
    }
    
}
