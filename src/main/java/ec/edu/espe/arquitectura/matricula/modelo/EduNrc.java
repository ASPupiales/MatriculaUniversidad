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
import javax.persistence.JoinColumns;
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
    @Column(name = "cupo_disponible")
    private short cupoDisponible;
    @Basic(optional = false)
    @Column(name = "cupo_registrado")
    private short cupoRegistrado;
    @Column(name = "nombre")
    private String nombre;
    @JoinColumns({
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EduMateria eduMateria;
    @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private EduPeriodo eduPeriodo;
    @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona")
    @ManyToOne(optional = false)
    private PerPersona codPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduNrc")
    private List<EduNrcHorario> eduNrcHorarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduNrc")
    private List<EduMatriculaNrc> eduMatriculaNrcList;

    public EduNrc() {
    }

    public EduNrc(EduNrcPK eduNrcPK) {
        this.eduNrcPK = eduNrcPK;
    }

    public EduNrc(EduNrcPK eduNrcPK, short cupoDisponible, short cupoRegistrado) {
        this.eduNrcPK = eduNrcPK;
        this.cupoDisponible = cupoDisponible;
        this.cupoRegistrado = cupoRegistrado;
    }

    public EduNrc(short codNrc, short codPeriodo, int codDepartamento, int codMateria) {
        this.eduNrcPK = new EduNrcPK(codNrc, codPeriodo, codDepartamento, codMateria);
    }

    public EduNrcPK getEduNrcPK() {
        return eduNrcPK;
    }

    public void setEduNrcPK(EduNrcPK eduNrcPK) {
        this.eduNrcPK = eduNrcPK;
    }

    public short getCupoDisponible() {
        return cupoDisponible;
    }

    public void setCupoDisponible(short cupoDisponible) {
        this.cupoDisponible = cupoDisponible;
    }

    public short getCupoRegistrado() {
        return cupoRegistrado;
    }

    public void setCupoRegistrado(short cupoRegistrado) {
        this.cupoRegistrado = cupoRegistrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EduMateria getEduMateria() {
        return eduMateria;
    }

    public void setEduMateria(EduMateria eduMateria) {
        this.eduMateria = eduMateria;
    }

    public EduPeriodo getEduPeriodo() {
        return eduPeriodo;
    }

    public void setEduPeriodo(EduPeriodo eduPeriodo) {
        this.eduPeriodo = eduPeriodo;
    }

    public PerPersona getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(PerPersona codPersona) {
        this.codPersona = codPersona;
    }

    @XmlTransient
    public List<EduNrcHorario> getEduNrcHorarioList() {
        return eduNrcHorarioList;
    }

    public void setEduNrcHorarioList(List<EduNrcHorario> eduNrcHorarioList) {
        this.eduNrcHorarioList = eduNrcHorarioList;
    }

    @XmlTransient
    public List<EduMatriculaNrc> getEduMatriculaNrcList() {
        return eduMatriculaNrcList;
    }

    public void setEduMatriculaNrcList(List<EduMatriculaNrc> eduMatriculaNrcList) {
        this.eduMatriculaNrcList = eduMatriculaNrcList;
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
