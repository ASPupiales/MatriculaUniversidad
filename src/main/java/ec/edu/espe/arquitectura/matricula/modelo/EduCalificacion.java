/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_calificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EduCalificacion.findAll", query = "SELECT e FROM EduCalificacion e")})
public class EduCalificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_calificacion")
    private Integer codCalificacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota1")
    private BigDecimal nota1;
    @Column(name = "nota2")
    private BigDecimal nota2;
    @Column(name = "nota3")
    private BigDecimal nota3;
    @Column(name = "nota4")
    private BigDecimal nota4;
    @Column(name = "nota5")
    private BigDecimal nota5;
    @Column(name = "nota6")
    private BigDecimal nota6;
    @Column(name = "nota7")
    private BigDecimal nota7;
    @Column(name = "nota8")
    private BigDecimal nota8;
    @Column(name = "nota9")
    private BigDecimal nota9;
    @Column(name = "nota10")
    private BigDecimal nota10;
    @Column(name = "promedio")
    private BigDecimal promedio;
    @Column(name = "estado")
    private String estado;
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "cod_inscripcion", referencedColumnName = "cod_matricula")
    @ManyToOne(optional = false)
    private EduMatricula codInscripcion;

    public EduCalificacion() {
    }

    public EduCalificacion(Integer codCalificacion) {
        this.codCalificacion = codCalificacion;
    }

    public Integer getCodCalificacion() {
        return codCalificacion;
    }

    public void setCodCalificacion(Integer codCalificacion) {
        this.codCalificacion = codCalificacion;
    }

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getNota3() {
        return nota3;
    }

    public void setNota3(BigDecimal nota3) {
        this.nota3 = nota3;
    }

    public BigDecimal getNota4() {
        return nota4;
    }

    public void setNota4(BigDecimal nota4) {
        this.nota4 = nota4;
    }

    public BigDecimal getNota5() {
        return nota5;
    }

    public void setNota5(BigDecimal nota5) {
        this.nota5 = nota5;
    }

    public BigDecimal getNota6() {
        return nota6;
    }

    public void setNota6(BigDecimal nota6) {
        this.nota6 = nota6;
    }

    public BigDecimal getNota7() {
        return nota7;
    }

    public void setNota7(BigDecimal nota7) {
        this.nota7 = nota7;
    }

    public BigDecimal getNota8() {
        return nota8;
    }

    public void setNota8(BigDecimal nota8) {
        this.nota8 = nota8;
    }

    public BigDecimal getNota9() {
        return nota9;
    }

    public void setNota9(BigDecimal nota9) {
        this.nota9 = nota9;
    }

    public BigDecimal getNota10() {
        return nota10;
    }

    public void setNota10(BigDecimal nota10) {
        this.nota10 = nota10;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public EduMatricula getCodInscripcion() {
        return codInscripcion;
    }

    public void setCodInscripcion(EduMatricula codInscripcion) {
        this.codInscripcion = codInscripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCalificacion != null ? codCalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduCalificacion)) {
            return false;
        }
        EduCalificacion other = (EduCalificacion) object;
        if ((this.codCalificacion == null && other.codCalificacion != null) || (this.codCalificacion != null && !this.codCalificacion.equals(other.codCalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduCalificacion[ codCalificacion=" + codCalificacion + " ]";
    }
    
}
