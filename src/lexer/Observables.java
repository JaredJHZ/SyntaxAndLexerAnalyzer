package lexer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Operators;

public class Observables {

    /*
        CLASE QUE CONTROLA LOS OBSERVABLES
     */
     public static ObservableList<Operators> caracteresEspeciales = FXCollections.observableArrayList(
            new Operators("A",  "1",  "5" ),
            new Operators("B",  "2",  "5" ),
            new Operators("C",  "3",  "5" ),
            new Operators("D",  "4",  "5" ),
            new Operators("E",  "5",  "5" ),
            new Operators("F",  "6",  "5" ),
            new Operators("G",  "7",  "5" ),
            new Operators("H",  "8",  "5" ),
            new Operators("I",  "9",  "5" ),
            new Operators("J",  "10",  "5" ),
            new Operators("K",  "11",  "5" ),
            new Operators("L",  "12",  "5" ),
            new Operators("M",  "13",  "5" ),
            new Operators("N",  "14",  "5" ),
            new Operators("O",  "15",  "5" ),
            new Operators("P",  "16",  "5" ),
            new Operators("Q",  "17",  "5" ),
            new Operators("R",  "18",  "5" ),
            new Operators("S",  "19",  "5" ),
            new Operators("T",  "20",  "5" ),
            new Operators("U",  "21",  "5" ),
            new Operators("V",  "22",  "5" ),
            new Operators("W",  "23",  "5" ),
            new Operators("X",  "24",  "5" ),
            new Operators("Y",  "25",  "5" ),
            new Operators("Z",  "26",  "5" ),
            new Operators("a",  "27",  "5" ),
            new Operators("b",  "28",  "5" ),
            new Operators("c",  "29",  "5" ),
            new Operators("d",  "30",  "5" ),
            new Operators("e",  "31",  "5" ),
            new Operators("f",  "32",  "5" ),
            new Operators("g",  "33",  "5" ),
            new Operators("h",  "34",  "5" ),
            new Operators("i",  "35",  "5" ),
            new Operators("j",  "36",  "5" ),
            new Operators("k",  "37",  "5" ),
            new Operators("l",  "38",  "5" ),
            new Operators("m",  "39",  "5" ),
            new Operators("n",  "40",  "5" ),
            new Operators("o",  "41",  "5" ),
            new Operators("p",  "42",  "5" ),
            new Operators("q",  "43",  "5" ),
            new Operators("r",  "44",  "5" ),
            new Operators("s",  "45",  "5" ),
            new Operators("t",  "46",  "5" ),
            new Operators("u",  "47",  "5" ),
            new Operators("v",  "48",  "5" ),
            new Operators("w",  "49",  "5" ),
            new Operators("x",  "50",  "5" ),
            new Operators("y",  "51",  "5" ),
            new Operators("z",  "52",  "5" ),
            new Operators("{",     "53",    "5" ),
            new Operators("}",  "54",  "5" ),
            new Operators("(",  "55",  "5" ),
            new Operators(")",  "56",  "5" ),
            new Operators("[",  "57",  "5" ),
            new Operators("]",  "58",  "5" ),
            new Operators("&&",  "59",  "5" ),
            new Operators("'",  "60",  "5" ),
            new Operators("|",  "61",  "5" ),
            new Operators("/",  "62",  "5" ),
            new Operators("`",  "63",  "5" ),
            new Operators("~",  "64",  "5" ),
            new Operators("_",  "65",  "5" ),
            new Operators("?",  "66",  "5" ),
            new Operators(":",  "67",  "5" ),
            new Operators(";",  "68",  "5" ),
            new Operators(".",  "69",  "5" ),
            new Operators("@",  "70",  "5" ),
            new Operators("ñ",  "71",  "5" )
    );

    public static ObservableList<Operators> operadoresRelacionales = FXCollections.observableArrayList(
            new Operators(">",     "1",    "2" ),
            new Operators("<",  "2",  "2" ),
            new Operators(">=",     "3", "2" ),
            new Operators("<=",      "4",    "2" ),
            new Operators("==",      "5",    "2" )
    );

    public static ObservableList<Operators> palabrasReservadas = FXCollections.observableArrayList(
            new Operators("for",     "1",    "4" ),
            new Operators("while",  "2",  "4" ),
            new Operators("integer",  "3",  "4" ),
            new Operators("decimal",  "4",  "4" ),
            new Operators("string",  "5",  "4" ),
            new Operators("bool",  "6",  "4" ),
            new Operators("console",  "7",  "4" ),
            new Operators("in",  "8",  "4" ),
            new Operators("out",  "9",  "4" ),
            new Operators("if",  "10",  "4" ),
            new Operators("else",  "11",  "4" )

    );

    public static ObservableList<Operators> operadoresAritmeticos = FXCollections.observableArrayList(
            new Operators("+",     "1",    "1" ),
            new Operators("-",  "2",  "1" ),
            new Operators("/",     "3", "1" ),
            new Operators("*",      "4",    "1" )
    );

    public static ObservableList<Operators> operadoresLogicos = FXCollections.observableArrayList(
            new Operators("||",     "1",    "3" ),
            new Operators("&&",  "2",  "3" )
    );





    public static String identificarTipo(String token) {

        System.out.println(token);

        for(var tk: caracteresEspeciales){
            if(token.equals(tk.getOperator())) {
                return tk.getIdem();
            }
        }

        for(var tk: operadoresRelacionales){
            if(token.equals(tk.getOperator())) {
                return tk.getIdem();
            }
        }

        for(var tk: palabrasReservadas){
            if(token.equals(tk.getOperator())) {
                return tk.getIdem();
            }
        }

        for(var tk: operadoresAritmeticos){
            if(token.equals(tk.getOperator())) {
                return tk.getIdem();
            }
        }

        for(var tk: operadoresLogicos){
            if(token.equals(tk.getOperator())) {
                return tk.getIdem();
            }
        }

        return "no encontrado";







    }

}
