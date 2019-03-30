package lexer;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Lexer{


    final ArrayList<Reservada> rs = new ArrayList<Reservada>(); // atributo de mi clase lexer que contendra un arraylist de instancias de Reservada aqui
    //sabre cuantos tipos de tokens tengo.


    public ArrayList<Token> lex(String entrada){
        final ArrayList<Token> tokens = new ArrayList<Token>(); //arraylist de tokens
        final StringTokenizer st = new StringTokenizer(entrada); // mi tokenizer que tendra el codigo que se pasa como parametro a entrada

        while(st.hasMoreTokens()){

            String palabra = st.nextToken(); //mi palabra es igual a el siguiente token

            boolean matched = false; //mi bandera de encuentra o relacionado la pongo en falso

            int i=0;   // creo una variable i y le asigno 0 esto lo hago para controlar que no haya dos tokens iguales pero relacionados con dos tipos diferentes

            for(Tipos tokenTipo: Tipos.values()){ // recorro todos mis tipos hasta allar el que corresponda a mi palabra



                Pattern patron = Pattern.compile(tokenTipo.patron);
                Matcher matcher = patron.matcher(palabra);

                if(matcher.find()){ // si se encuentra pues hahcemos el proceso de agregar el tipo al token , el valor y inicializar o aumentar al contador de tipos
                    i++;

                    if(i<=1) { //condicional para que no se repita el token con diferentes tipos
                        boolean ok=true;
                        Token tk = new Token();


                        tk.setTipo(tokenTipo);
                        tk.setValor(palabra);
                        tokens.add(tk);

                        //checo si mi arraylist esta vacio si no es asi recorro todo para saber cual se repite y agregarle al contador uno mas de ese tipo
                        //pongo mi bandera en false si no existe la palabra reservada pues mi bandera ase queda en true asi que creo una instancia de Reservada y la agrego
                        // a mi arraylist

                        if(rs.isEmpty()){
                            Reservada r = new Reservada(tk.getTipo().toString());
                            rs.add(r);
                        }else{
                            for(Reservada x:rs){

                                if(x.reservada.equals(tk.getTipo().toString())){

                                    x.size++;
                                    ok=false;
                                }
                            }
                            if(ok==true){
                                Reservada r = new Reservada(tk.getTipo().toString());
                                rs.add(r);
                            }

                        }
                        matched=true;
                        System.out.println(i);

                    }
                }
                if(!matched){
                    //   throw new RuntimeException("No existe tal token");
                }

            }

        }

        return tokens; //regreso mi arraylist de tokens.
    }
}
}