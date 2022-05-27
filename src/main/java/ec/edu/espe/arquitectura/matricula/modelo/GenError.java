package ec.edu.espe.arquitectura.matricula.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gen_error")
public class GenError implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "cod_error", nullable = false, length = 5)
    private String codError;
    @Basic(optional = false)
    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 1000)
    private String descripcion;

    public GenError() {
    }

    public GenError(String codError) {
        this.codError = codError;
    }

    public String getCodError() {
        return codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codError != null ? codError.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof GenError)) {
            return false;
        }
        GenError other = (GenError) object;
        if ((this.codError == null && other.codError != null) || (this.codError != null && !this.codError.equals(other.codError))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GenError[ codError=" + codError + " ]";
    }
    
}
