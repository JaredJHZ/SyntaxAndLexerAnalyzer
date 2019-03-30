package sample;

public class Operators {
    String operator, idem, ai;

    public Operators(String operator, String IDEM, String AI) {
        this.operator = operator;
        this.idem = IDEM;
        this.ai = AI;
    }

    public String getAi() {
        return this.ai;
    }

    public String getIdem() {
        return this.idem;
    }

    public String getOperator() {
        return this.operator;
    }

}