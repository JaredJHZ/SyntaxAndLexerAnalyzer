package lexer;

public class Token {
    public  int size;
    private Tipos tipo=null;
    private String valor;
    public Tipos getTipo(){
        return tipo;
    }
    public void setTipo(Tipos tipo){
        this.tipo = tipo;
    }
    public void setValor(String valor){
        this.valor = valor;
    }
    public String getValor(){
        return this.valor;
    }


}
enum Tipos{
    Numero("[0-9]{1,9}(\\.[0-9]{0,2})?$"),
    OperadorArtitmetico("[*|/?|+|-]"),
    Letras("[A-Z]"),
    tabulador("\\t"),
    cicloFor("for"),
    cicloWhile("while"),
    palabraReservadaClase("clase"),
    palabraReservadaConstante("define"),
    dosPuntos(":"),
    operadorLogico("[<|>|=|!=]"),
    saltoDeLinea("\\n"),
    variables("[a-zA-ZñÑ\\s][^(int)][^(clase)][^(float)]"),
    Tipo("(?i)(\\W|^)(int|void|clase|char|float\\smía|double|boolean)(\\W|$)"),
    parentesis("[(?)]"),
    //espacio("((.*)\\n*)"),
    puntoFinal("\\."),
    delimitador("[{?}]")
    ;
    ;
    public final String patron;
    Tipos(String s){
        this.patron = s;
    }
}