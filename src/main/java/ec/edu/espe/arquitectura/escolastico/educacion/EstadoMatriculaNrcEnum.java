package ec.edu.espe.arquitectura.escolastico.educacion;

public enum EstadoMatriculaNrcEnum {

    APROBADO("APR", "Aprobado"),
    REPROBADO("REP", "Reprobado"),
    PENDIENTE("PEN", "Pendiente");

    private final String valor;

    private final String texto;

    private EstadoMatriculaNrcEnum(String valor, String texto) {
        this.valor = valor;
        this.texto = texto;
    }

    public String getValor() {
        return valor;
    }

    public String getTexto() {
        return texto;
    }

}
