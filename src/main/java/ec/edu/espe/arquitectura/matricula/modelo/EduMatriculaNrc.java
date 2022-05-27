/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_matricula_nrc")
@NamedQueries({
    @NamedQuery(name = "EduMatriculaNrc.findAll", query = "SELECT e FROM EduMatriculaNrc e")})
public class EduMatriculaNrc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EduMatriculaNrcPK eduMatriculaNrcPK;
    @Basic(optional = false)
    @Column(name = "estado", nullable = false, length = 3)
    private String estado;
    @Basic(optional = false)
    @Column(name = "numero", nullable = false)
    private short numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "costo", nullable = false, precision = 7, scale = 2)
    private BigDecimal costo;
    @JoinColumns({
        @JoinColumn(name = "cod_matricula", referencedColumnName = "cod_matricula", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_persona", referencedColumnName = "cod_persona", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EduMatricula eduMatricula;
    @JoinColumns({
        @JoinColumn(name = "cod_nrc", referencedColumnName = "cod_nrc", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_periodo", referencedColumnName = "cod_periodo", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false, insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private EduNrc eduNrc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMatriculaNrc")
    private List<EduCalificacion> eduCalificacionList;

    public EduMatriculaNrc() {
    }

    public EduMatriculaNrc(EduMatriculaNrcPK eduMatriculaNrcPK) {
        this.eduMatriculaNrcPK = eduMatriculaNrcPK;
    }

    public EduMatriculaNrc(EduMatriculaNrcPK eduMatriculaNrcPK, String estado, short numero, BigDecimal costo) {
        this.eduMatriculaNrcPK = eduMatriculaNrcPK;
        this.estado = estado;
        this.numero = numero;
        this.costo = costo;
    }

    public EduMatriculaNrc(String codMatricula, int codPersona, short codNrc, short codPeriodo, int codDepartamento, int codMateria) {
        this.eduMatriculaNrcPK = new EduMatriculaNrcPK(codMatricula, codPersona, codNrc, codPeriodo, codDepartamento, codMateria);
    }

    public EduMatriculaNrcPK getEduMatriculaNrcPK() {
        return eduMatriculaNrcPK;
    }

    public void setEduMatriculaNrcPK(EduMatriculaNrcPK eduMatriculaNrcPK) {
        this.eduMatriculaNrcPK = eduMatriculaNrcPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public EduMatricula getEduMatricula() {
        return eduMatricula;
    }

    public void setEduMatricula(EduMatricula eduMatricula) {
        this.eduMatricula = eduMatricula;
    }

    public EduNrc getEduNrc() {
        return eduNrc;
    }

    public void setEduNrc(EduNrc eduNrc) {
        this.eduNrc = eduNrc;
    }

    public List<EduCalificacion> getEduCalificacionList() {
        return eduCalificacionList;
    }

    public void setEduCalificacionList(List<EduCalificacion> eduCalificacionList) {
        this.eduCalificacionList = eduCalificacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduMatriculaNrcPK != null ? eduMatriculaNrcPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduMatriculaNrc)) {
            return false;
        }
        EduMatriculaNrc other = (EduMatriculaNrc) object;
        if ((this.eduMatriculaNrcPK == null && other.eduMatriculaNrcPK != null) || (this.eduMatriculaNrcPK != null && !this.eduMatriculaNrcPK.equals(other.eduMatriculaNrcPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduMatriculaNrc[ eduMatriculaNrcPK=" + eduMatriculaNrcPK + " ]";
    }
    
}
