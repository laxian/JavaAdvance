package algorithm.exp.exp;

public class SubExp implements Exp {

    private final String exp;

    public SubExp(String str) {
        this.exp = str;
    }

    @Override
    public double calculate() {
        String[] split = exp.split("-");
        return Double.parseDouble(split[0]) - Double.parseDouble(split[1]);
    }
}
