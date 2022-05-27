package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author labox
 */
@Entity
@Table(name = "edu_materia")
public class EduMateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EduMateriaPK eduMateriaPK;
    
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    
    @Column(name = "creditos", nullable = false, precision = 4, scale = 2)
    private BigDecimal creditos;
    
    @Column(name = "horas", nullable = false, precision = 4, scale = 2)
    private BigDecimal horas;
    
    @Column(name = "ponderacion", nullable = false, precision = 5, scale = 2)
    private BigDecimal ponderacion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMateria")
    private List<EduPrerequisito> eduPrerequisitoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduMateria1")
    private List<EduPrerequisito> eduPrerequisitoList1;
    
    @JoinColumn(name = "cod_departamento", referencedColumnName = "cod_departamento", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private EduDepartamento eduDepartamento;

    public EduMateria() {
    }

    public EduMateria(EduMateriaPK eduMateriaPK) {
        this.eduMateriaPK = eduMateriaPK;
    }

    public EduMateria(int codMateria, int codDepartamento) {
        this.eduMateriaPK = new EduMateriaPK(codMateria, codDepartamento);
    }

    public EduMateriaPK getEduMateriaPK() {
        return eduMateriaPK;
    }

    public void setEduMateriaPK(EduMateriaPK eduMateriaPK) {
        this.eduMateriaPK = eduMateriaPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCreditos() {
        return creditos;
    }

    public void setCreditos(BigDecimal creditos) {
        this.creditos = creditos;
    }

    public BigDecimal getHoras() {
        return horas;
    }

    public void setHoras(BigDecimal horas) {
        this.horas = horas;
    }

    public BigDecimal getPonderacion() {
        return ponderacion;
    }

    public void setPonderacion(BigDecimal ponderacion) {
        this.ponderacion = ponderacion;
    }

    public List<EduPrerequisito> getEduPrerequisitoList() {
        return eduPrerequisitoList;
    }

    public void setEduPrerequisitoList(List<EduPrerequisito> eduPrerequisitoList) {
        this.eduPrerequisitoList = eduPrerequisitoList;
    }

    public List<EduPrerequisito> getEduPrerequisitoList1() {
        return eduPrerequisitoList1;
    }

    public void setEduPrerequisitoList1(List<EduPrerequisito> eduPrerequisitoList1) {
        this.eduPrerequisitoList1 = eduPrerequisitoList1;
    }

    public EduDepartamento getEduDepartamento() {
        return eduDepartamento;
    }

    public void setEduDepartamento(EduDepartamento eduDepartamento) {
        this.eduDepartamento = eduDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eduMateriaPK != null ? eduMateriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EduMateria)) {
            return false;
        }
        EduMateria other = (EduMateria) object;
        if ((this.eduMateriaPK == null && other.eduMateriaPK != null) || (this.eduMateriaPK != null && !this.eduMateriaPK.equals(other.eduMateriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "eduMateriaPK=" + eduMateriaPK;
    }
    
}
