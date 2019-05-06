package lexer;

import javafx.collections.ObservableList;
import sample.TK;

import java.util.Stack;

import static lexer.Tipos.*;


public class Syntax {

Stack<TK> pilaSyntax;
Stack<Error> errores;

    public Syntax(){
        this.pilaSyntax = new Stack<TK>();
        this.errores = new Stack<Error>();
    }

    public Stack<Error> effectSyntax(){

        this.checkSyntax(0,null,this.pilaSyntax);
        return this.errores;
    }



    public Boolean addElements(ObservableList<TK> tokens){
        this.pilaSyntax.clear();
        for(var token: tokens) {
            this.pilaSyntax.add(token);
        }
        return true;
    }

    private TK checkSyntax(int n, TK prev, Stack<TK> pila)  {
        if(n == pila.size()) {
            return null;
        }else {
            if(this.procedure(prev,pila.elementAt(n))){

            }else{
                var mensaje = pila.elementAt(n).getValor();
                var linea = pila.elementAt(n).getLinea();
                Error e = new Error(mensaje, Integer.valueOf(linea));
                this.errores.add(e);

            }
            return checkSyntax(n+1,pila.get(n),pila);
        }
    }

    private Boolean procedure(TK previous, TK actual) {
        if(previous == null){
            if (actual.getValor().matches("void")){
                return true;
            } else {
                return false;
            }

        }
        System.out.println(previous.getValor());
        switch (previous.getValor()) {
            case "void": {
                return actual.getValor().matches("main");
            }
            case "main": {
                return actual.getValor().matches( "\\{");
            }
            case "(": {
                if (actual.getValor() == "(" || actual.getValor().matches(OperadorArtitmetico.patron ) || actual.getValor().matches(OperadoresLogicos.patron ) ) {
                    return false;
                } else {
                    return true;
                }
            }
            case ")": {
                return actual.getValor() == "begin" || actual.getValor() == "\\}";
            }
            case "{":{
                return actual.getValor().matches(PalabrasReservadas.patron);
            }
            case "integer":{
                return actual.getValor().matches(Variables.patron);
            }
            case "string":{
                return actual.getValor().matches(Variables.patron);
            }
            default:
                if (previous.getValor().matches("\\w")){
                    System.out.println(actual.getValor());
                    if (actual.getValor().matches("\\}")){
                        return true;
                    } else{
                        System.out.println("xddd");
                    }
                }
        }

        return false;

    }


}
