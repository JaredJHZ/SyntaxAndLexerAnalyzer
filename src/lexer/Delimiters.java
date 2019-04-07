package lexer;

public enum Delimiters {
    delimiters("((?<=[\\(|\\)|\\s+|\\{|\\}|\\+|\\-|\\/|//*])|(?=[\\(|\\)|\\s+|\\{|\\}|\\+|\\-|\\/|//*]))");

    public final String patron;

    Delimiters(String s){
        this.patron = s;
    }


}
