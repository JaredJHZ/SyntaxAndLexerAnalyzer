package lexer;

public class Token {

    public Tipos tipo = null;

    public String valor;

    public String grupo;

    public String linea;


    public void setTipo(Tipos tipo){
        this.tipo = tipo;
    }
    public void setValor(String valor){
        this.valor = valor;
    }
    public void setGrupo(int grupo) {this.grupo = String.valueOf(grupo);}
    public void setLinea(int linea) {this.linea = String.valueOf(linea);}

    public String getValor(){
        return this.valor;
    }
    public String getTipo() {
        return this.tipo.name();
    }
    public String getGrupo() {return this.grupo;}
    public String getLinea() {return this.linea;}



}
enum Tipos{
    NumeroEntero("^\\d+${1}"),
    NumeroDecimal("^[-+]?\\d+(\\.\\d+)?${1}"),
    OperadorArtitmetico("[*|//|+|-]+{1}"),
    OperadoresLogicos("[&&,/|/|]"),
    OperadoresRelacionales("[>|<|>=|<=|==|!=]"),
    PalabrasReservadas("\\bstring|bool|integer|decimal|for|else|if\\b{1}"),
    CaracteresEspeciales("\\b\\{|\\}|\\(|\\)|\\@|\\&|\\'|\\||\\`|\\~|\\?|\\:|\\;\\b"),
    Variables("\\w")
    ;
    public final String patron;

    Tipos(String s){
        this.patron = s;
    }
}