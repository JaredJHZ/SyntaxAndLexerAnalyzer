package sample;

public class MathOperators {
    String operator, idem, ai;

    public MathOperators(String operator, String IDEM, String AI) {
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