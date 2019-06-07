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

        this.checkSyntax(this.pilaSyntax);
        return this.errores;
    }



    public Boolean addElements(ObservableList<TK> tokens){
        this.pilaSyntax.clear();
        for(var token: tokens) {
            this.pilaSyntax.add(token);
        }
        return true;
    }

    /*
    private TK checkSyntax(int n, TK prev, Stack<TK> pila)  {
        if(n == pila.size()) {
            return null;
        }else {
            if(this.procedure(prev,pila.elementAt(n))){

            }else{
                System.out.println(pila.elementAt(n).getValor());
                var mensaje = pila.elementAt(n).getValor();
                var linea = pila.elementAt(n).getLinea();
                Error e = new Error(mensaje, Integer.valueOf(linea));
                this.errores.add(e);

            }
            return checkSyntax(n+1,pila.get(n),pila);
        }
    }
    */

    private void checkSyntax (Stack<TK> pila) {
        boolean fin = false;
        boolean apertura = false;
        int lineaApertura = 0;
        int i = 0;
        while (i < pila.size() - 1) {
            if (pila.get(i).getValor().equals("(")) {
                apertura = true;
                lineaApertura = Integer.valueOf(pila.get(i).getLinea());
            }

            if (pila.get(i).getValor().equals(")")) {
                apertura = false;
            }

            if (! procedure(pila.get(i), pila.get(i + 1)) ) {
                var mensaje = " Error en la expresion ";
                if (pila.get(i).getValor().equals("=")) {
                    mensaje = " Error en la asignacion ";
                }

                if (pila.get(i).getGrupo().equals("1")) {
                    mensaje = "Error en la operacion aritmetica";
                }

                if (pila.get(i).getGrupo().equals("2")) {
                    mensaje = "Error en la operacion relacional";
                }

                if (pila.get(i).getGrupo().equals("3")){
                    mensaje = "Error en la operacion logica";
                }

                if (pila.get(i).getValor().equals("{")) {
                    mensaje = "Se esperaba alguna operacion";
                }

                var linea = pila.elementAt(i).getLinea();
                Error e = new Error(mensaje, Integer.valueOf(linea));
                this.errores.add(e);
            }
            i+=1;
        }

        if (apertura) {
            var mensaje = " Error, falta cerrar parentesis ";
            var linea = lineaApertura;
            Error e = new Error(mensaje,linea);
            this.errores.add(e);
        }


        if (this.pilaSyntax.size() > 3) {
            if (!this.pilaSyntax.get(0).getValor().matches("void")) {
                var mensaje = " Error en la estructura se esperaba 'void' ";
                var linea = pila.elementAt(1).getLinea();
                Error e = new Error(mensaje, Integer.valueOf(linea));
                this.errores.add(e);
            }

            if (!this.pilaSyntax.get(1).getValor().matches("main"))
            {
                var mensaje = " Error en la estructura se esperaba 'main' ";
                var linea = pila.elementAt(2).getLinea();
                Error e = new Error(mensaje, Integer.valueOf(linea));
                this.errores.add(e);
            }

            if (!this.pilaSyntax.get(2).getValor().equals("{"))
            {
                var mensaje = " Error en la estructura se esperaba  '{' ";
                var linea = pila.elementAt(3).getLinea();
                Error e = new Error(mensaje, Integer.valueOf(linea));
                this.errores.add(e);
            }


            if (!this.pilaSyntax.get(this.pilaSyntax.size() - 1).getValor().equals("}"))
            {
                var mensaje = " Error falta cerrar la estructura principal del programa";
                var linea = pila.elementAt(this.pilaSyntax.size() - 1).getLinea();
                Error e = new Error(mensaje, Integer.valueOf(linea));
                this.errores.add(e);
            }
        } else {
            var mensaje = pila.elementAt(0).getValor();
            var linea = pila.elementAt(0).getLinea();
            Error e = new Error(mensaje, Integer.valueOf(linea));
            this.errores.add(e);
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
        switch (previous.getValor()) {
            case "void": {
                return actual.getValor().matches("main");
            }
            case "main": {
                return actual.getValor().matches( "\\{");
            }
            case ",": {
                if (actual.getGrupo().equals("6")) {
                    return true;
                }
            }
            case "(": {
                if (actual.getValor() == "(" || actual.getValor().matches(OperadorArtitmetico.patron ) || actual.getValor().matches(OperadoresLogicos.patron )  ) {
                    return false;
                } else {
                    return true;
                }
            }
            case ")": {
                return true;
            }
            case "{":{
                return actual.getValor().matches(PalabrasReservadas.patron) || actual.getValor().matches(Variables.patron);
            }
            case "integer":{
                return actual.getGrupo().matches("6") && !actual.getValor().matches("=");
            }
            case "string":{
                return actual.getGrupo().matches("6") && !actual.getValor().matches("=");
            }
            case "boolean":{
                return actual.getGrupo().matches("6") && !actual.getValor().matches("=");
            }
            case "decimal":{
                return actual.getGrupo().matches("6") && !actual.getValor().matches("=");
            }
            case ";" :{
                return actual.getValor().matches(Variables.patron);
            }
            case "=": {
                return actual.getValor().matches(Variables.patron) || actual.getValor().matches(NumeroEntero.patron) || actual.getValor().matches(NumeroDecimal.patron) || actual.getValor().matches(cadena.patron);
            }
            default:
                if (previous.getValor().matches(asignacion.patron)) {
                    return actual.getValor().matches(cadena.patron) || actual.getValor().matches(NumeroEntero.patron ) || actual.getValor().matches(NumeroDecimal.patron);

                }

                if (previous.getValor().matches(NumeroEntero.patron)) {
                    return actual.getValor().matches(",") || actual.getGrupo().equals("3") || actual.getValor().matches(OperadorArtitmetico.patron) || actual.getValor().matches(Variables.patron) || actual.getValor().equals("}") || actual.getValor().matches(PalabrasReservadas.patron) ||  actual.getValor().equals(")") ;
                }

                if (previous.getValor().matches(NumeroDecimal.patron)) {
                    return actual.getValor().equals(",") || actual.getGrupo().equals("3")  ||actual.getValor().matches(OperadorArtitmetico.patron) || actual.getValor().matches(Variables.patron) || actual.getValor().matches(PalabrasReservadas.patron)  || actual.getValor().equals("}") || actual.getValor().matches(PalabrasReservadas.patron);
                }

                if (previous.getValor().matches(OperadorArtitmetico.patron)) {
                    return actual.getValor().matches(NumeroEntero.patron) || actual.getValor().matches(NumeroDecimal.patron) || actual.getGrupo().equals("6") || actual.getValor().equals(")") || actual.getValor().equals(previous.getValor()) || actual.getValor().equals("(") ;
                }

                if (previous.getValor().matches(OperadoresLogicos.patron)) {
                    return actual.getValor().matches(NumeroEntero.patron) || actual.getValor().matches(Variables.patron) || actual.getValor().equals("(");
                }

                if (previous.getValor().matches(OperadoresRelacionales.patron)) {
                    return actual.getValor().matches(NumeroEntero.patron) || actual.getValor().matches(Variables.patron);
                }

                if (previous.getGrupo().equals("6")) {
                    return actual.getGrupo().equals("6") || actual.getValor().equals("}") || actual.getValor().equals("boolean") || actual.getValor().matches(PalabrasReservadas.patron) || actual.getValor().equals("=") || actual.getValor().matches(OperadorArtitmetico.patron) || actual.getValor().matches(OperadoresRelacionales.patron) || actual.getValor().equals("(") || actual.getValor().equals(")");
                }


                if (previous.getValor().matches("for")) {
                    if (actual.getValor().matches("\\(")) {
                        return true;
                    }
                }

                if (previous.getValor().matches(cadena.patron)){
                    System.out.println(actual.getGrupo());
                    return true;
                }




        }


        if (actual.getValor().matches("}")){
            return true;
        }
        return true;

    }


}
