package algorithm.exp.exp;

public class MulExp implements Exp {

    private final String exp;

    public MulExp(String exp) {
        this.exp = exp;
    }

    @Override
    public double calculate() {
        String[] split = exp.split("\\*");
        return Double.parseDouble(split[0]) * Double.parseDouble(split[1]);
    }
}
