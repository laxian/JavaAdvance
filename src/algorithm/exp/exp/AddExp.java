package algorithm.exp.exp;

import algorithm.exp.oper.AddOper;

public class AddExp implements Exp {

    private final String exp;

    public AddExp(String str) {
        this.exp = str;
    }

    @Override
    public double calculate() {
        String[] split = exp.split("\\+");
        return new AddOper().apply(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }
}
