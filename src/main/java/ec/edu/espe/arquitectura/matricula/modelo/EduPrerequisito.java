/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_prerequisito")
@NamedQueries({
    @NamedQuery(name = "EduPrerequisito.findAll", query = "SELECT e FROM EduPrerequisito e")})
public class EduPrerequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_prerequisito", nullable = false)
    private Integer codPrerequisito;
    @Basic(optional = false)
    @Column(name = "tipo", nullable = false, length = 3)
    private String tipo;
    @JoinColumns({
        @JoinColumn(name = "cod_materia", referencedColumnName = "cod_materia", nullable = false),
        @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false)})
    @ManyToOne(optional = false)
    private EduMateria eduMateria;
    @JoinColumns({
        @JoinColumn(name = "cod_materia_prerequisito", referencedColumnName = "cod_materia", nullable = false),
        @JoinColumn(name = "edu_cod_departamento", referencedColumnName = "cod_departamento", nullable = false)})
    @ManyToOne(optional = false)
    private EduMateria eduMateria1;

    public EduPrerequisito() {
    }

    public EduPrerequisito(Integer codPrerequisito) {
        this.codPrerequisito = codPrerequisito;
    }

    public EduPrerequisito(Integer codPrerequisito, String tipo) {
        this.codPrerequisito = codPrerequisito;
        this.tipo = tipo;
    }

    public Integer getCodPrerequisito() {
        return codPrerequisito;
    }

    public void setCodPrerequisito(Integer codPrerequisito) {
        this.codPrerequisito = codPrerequisito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public EduMateria getEduMateria() {
        return eduMateria;
    }

    public void setEduMateria(EduMateria eduMateria) {
        this.eduMateria = eduMateria;
    }

    public EduMateria getEduMateria1() {
        return eduMateria1;
    }

    public void setEduMateria1(EduMateria eduMateria1) {
        this.eduMateria1 = eduMateria1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPrerequisito != null ? codPrerequisito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduPrerequisito)) {
            return false;
        }
        EduPrerequisito other = (EduPrerequisito) object;
        if ((this.codPrerequisito == null && other.codPrerequisito != null) || (this.codPrerequisito != null && !this.codPrerequisito.equals(other.codPrerequisito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.matricula.modelo.EduPrerequisito[ codPrerequisito=" + codPrerequisito + " ]";
    }
    
}
