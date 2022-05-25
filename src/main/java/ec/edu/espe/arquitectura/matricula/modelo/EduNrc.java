/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_nrc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EduNrc.findAll", query = "SELECT e FROM EduNrc e")})
public class EduNrc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EduNrcPK eduNrcPK;
    @Basic(optional = false)
    @Column(name = "cupos")
    private int cupos;
    @JoinColumn(name = "cod_docente", referencedColumnName = "cod_docente")
    @ManyToOne
    private EduAsignacionDocente codDocente;
    @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia")
    @ManyToOne(optional = false)
    private EduMateria codMateria;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EduPeriodo eduPeriodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduNrc")
    private List<EduMatricula> eduMatriculaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduNrc")
    private List<EduNrcAula> eduNrcAulaList;

    public EduNrc() {
    }

    public EduNrc(EduNrcPK eduNrcPK) {
        this.eduNrcPK = eduNrcPK;
    }

    public EduNrc(EduNrcPK eduNrcPK, int cupos) {
        this.eduNrcPK = eduNrcPK;
        this.cupos = cupos;
    }

    public EduNrc(short codNrc, int codPeriodo) {
        this.eduNrcPK = new EduNrcPK(codNrc, codPeriodo);
    }

    public EduNrcPK getEduNrcPK() {
        return eduNrcPK;
    }

    public void setEduNrcPK(EduNrcPK eduNrcPK) {
        this.eduNrcPK = eduNrcPK;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public EduAsignacionDocente getCodDocente() {
        return codDocente;
    }

    public void setCodDocente(EduAsignacionDocente codDocente) {
        this.codDocente = codDocente;
    }

    public EduMateria getCodMateria() {
        return codMateria;
    }

    public void setCodMateria(EduMateria codMateria) {
        this.codMateria = codMateria;
    }

    public EduPeriodo getEduPeriodo() {
        return eduPeriodo;
    }

    public void setEduPeriodo(EduPeriodo eduPeriodo) {
        this.eduPeriodo = eduPeriodo;
    }

    @XmlTransient
    public List<EduMatricula> getEduMatriculaList() {
        return eduMatriculaList;
    }

    public void setEduMatriculaList(List<EduMatricula> eduMatriculaList) {
        this.eduMatriculaList = eduMatriculaList;
    }

    @XmlTransient
    public List<EduNrcAula> getEduNrcAulaList() {
        return eduNrcAulaList;
    }

    public void setEduNrcAulaList(List<EduNrcAula> eduNrcAulaList) {
        this.eduNrcAulaList = eduNrcAulaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduNrcPK != null ? eduNrcPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduNrc)) {
            return false;
        }
        EduNrc other = (EduNrc) object;
        if ((this.eduNrcPK == null && other.eduNrcPK != null) || (this.eduNrcPK != null && !this.eduNrcPK.equals(other.eduNrcPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduNrc[ eduNrcPK=" + eduNrcPK + " ]";
    }
    
}
