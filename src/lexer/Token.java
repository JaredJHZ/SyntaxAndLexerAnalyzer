package lexer;

public class Token {

    public Tipos tipo = null;

    public String valor;

    public String grupo;

    public String linea;

    public String idem;


    public void setTipo(Tipos tipo){
        this.tipo = tipo;
    }
    public void setValor(String valor){
        this.valor = valor;
    }
    public void setGrupo(int grupo) {this.grupo = String.valueOf(grupo);}
    public void setLinea(int linea) {this.linea = String.valueOf(linea);}
    public void setIdem(String idem) { this.idem = idem;}

    public String getValor(){
        return this.valor;
    }
    public String getTipo() {
        return this.tipo.name();
    }
    public String getGrupo() {return this.grupo;}
    public String getLinea() {return this.linea;}
    public String getIdem() {return this.idem;}



}
enum Tipos{
    NumeroEntero("^\\d+${1}"),
    NumeroDecimal("^[-+]?\\d+(\\.\\d+)?${1}"),
    cadena("\"(?:'.*?')|(?:\\\".*?\\\")"),
    asignacion("="),
    OperadorArtitmetico("(?>[*|//|+|-]+){1}"),
    OperadoresLogicos("[&&,/|/|]"),
    OperadoresRelacionales("[>|<|>=|<=|==|!=]"),
    PalabrasReservadas("((\\bstring\\b)|(\\bbool\\b)|(\\binteger\\b)|(\\bdecimal\\b)|(\\bfor\\b)|(\\belse\\b)|(\\bif\\b)|(\\bvoid\\b)|(\\bmain\\b)|(\\bbegin\\b)|(\\bend\\b)){1}"),
    CaracteresEspeciales("[\\{|\\}|\\(|\\)|\\@|\\&|\\'|\\||\\`|\\~|\\?|\\:|\\;]"),
    Variables("\\w")
    ;
    public final String patron;

    Tipos(String s){
        this.patron = s;
    }
}