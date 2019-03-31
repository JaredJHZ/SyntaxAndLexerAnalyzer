package sample;

public class TK {

    String valor;
    String tipo;
    String grupo;
    String linea;

    public TK(String valor, String tipo, String grupo, String linea) {
        this.valor = valor;
        this.tipo = tipo;
        this.grupo = grupo;
        this.linea = linea;
    }

    public String getValor() {
        return this.valor;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getGrupo(){return  this.grupo;}

    public String getLinea() {return this.linea;}
}
