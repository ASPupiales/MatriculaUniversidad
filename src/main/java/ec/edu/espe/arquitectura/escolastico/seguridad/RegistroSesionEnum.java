package ec.edu.espe.arquitectura.escolastico.seguridad;

public enum RegistroSesionEnum {
    SATISFACTORIO("SAT","Satisfactorio"),
    FALLIDO("FAL","Fallido");

    private final String valor;
    private final String texto;

    RegistroSesionEnum(String valor, String texto) {
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
