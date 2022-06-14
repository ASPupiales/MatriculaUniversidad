package ec.edu.espe.arquitectura.escolastico.educacion;

public enum PrerequisitoEnum {

    OBLIGATORIO("OBL", "Obligatorio"),
    OPCIONAL("OPC", "Opcional");

    private final String valor;
    private final String texto;

    private PrerequisitoEnum(String valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }

    public String getValor() {
        return this.valor;
    }

    public String getTexto() {
        return this.texto;
    }
    
}
