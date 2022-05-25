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
@Table(name = "edu_prerequisito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EduPrerequisito.findAll", query = "SELECT e FROM EduPrerequisito e")})
public class EduPrerequisito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_prerequisito")
    private Integer codPrerequisito;
    @Basic(optional = false)
    @Column(name = "agrupacion_prerequisitos")
    private int agrupacionPrerequisitos;
    @JoinColumn(name = "cod_materia_padre", referencedColumnName = "cod_materia")
    @ManyToOne(optional = false)
    private EduMateria codMateriaPadre;
    @JoinColumn(name = "edu_cod_materia", referencedColumnName = "cod_materia")
    @ManyToOne(optional = false)
    private EduMateria eduCodMateria;

    public EduPrerequisito() {
    }

    public EduPrerequisito(Integer codPrerequisito) {
        this.codPrerequisito = codPrerequisito;
    }

    public EduPrerequisito(Integer codPrerequisito, int agrupacionPrerequisitos) {
        this.codPrerequisito = codPrerequisito;
        this.agrupacionPrerequisitos = agrupacionPrerequisitos;
    }

    public Integer getCodPrerequisito() {
        return codPrerequisito;
    }

    public void setCodPrerequisito(Integer codPrerequisito) {
        this.codPrerequisito = codPrerequisito;
    }

    public int getAgrupacionPrerequisitos() {
        return agrupacionPrerequisitos;
    }

    public void setAgrupacionPrerequisitos(int agrupacionPrerequisitos) {
        this.agrupacionPrerequisitos = agrupacionPrerequisitos;
    }

    public EduMateria getCodMateriaPadre() {
        return codMateriaPadre;
    }

    public void setCodMateriaPadre(EduMateria codMateriaPadre) {
        this.codMateriaPadre = codMateriaPadre;
    }

    public EduMateria getEduCodMateria() {
        return eduCodMateria;
    }

    public void setEduCodMateria(EduMateria eduCodMateria) {
        this.eduCodMateria = eduCodMateria;
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
