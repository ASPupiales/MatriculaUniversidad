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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "edu_asignacion_docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EduAsignacionDocente.findAll", query = "SELECT e FROM EduAsignacionDocente e")})
public class EduAsignacionDocente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_docente")
    private Integer codDocente;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @OneToMany(mappedBy = "codDocente")
    private List<EduNrc> eduNrcList;
    @JoinColumns({
        @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona"),
        @JoinColumn(name = "cod_tipo_persona", referencedColumnName = "cod_tipo_persona")})
    @ManyToOne
    private PerHistTipoPersona perHistTipoPersona;

    public EduAsignacionDocente() {
    }

    public EduAsignacionDocente(Integer codDocente) {
        this.codDocente = codDocente;
    }

    public EduAsignacionDocente(Integer codDocente, Date fecha) {
        this.codDocente = codDocente;
        this.fecha = fecha;
    }

    public Integer getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(Integer codDocente) {
        this.codDocente = codDocente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @XmlTransient
    public List<EduNrc> getEduNrcList() {
        return eduNrcList;
    }

    public void setEduNrcList(List<EduNrc> eduNrcList) {
        this.eduNrcList = eduNrcList;
    }

    public PerHistTipoPersona getPerHistTipoPersona() {
        return perHistTipoPersona;
    }

    public void setPerHistTipoPersona(PerHistTipoPersona perHistTipoPersona) {
        this.perHistTipoPersona = perHistTipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDocente != null ? codDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduAsignacionDocente)) {
            return false;
        }
        EduAsignacionDocente other = (EduAsignacionDocente) object;
        if ((this.codDocente == null && other.codDocente != null) || (this.codDocente != null && !this.codDocente.equals(other.codDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduAsignacionDocente[ codDocente=" + codDocente + " ]";
    }
    
}
