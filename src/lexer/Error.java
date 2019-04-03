package lexer;

public class Error {
    String mensaje;
    int linea;

    Error(String mensaje, int linea) {
        this.mensaje = mensaje;
        this.linea = linea;
    }

    public String getMensjae(){
        return this.mensaje;
    }

    public String getLinea(){
        return String.valueOf(this.linea);
    }
}
