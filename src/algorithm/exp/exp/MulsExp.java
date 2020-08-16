package algorithm.exp.exp;

public class MulsExp implements Exp {

    private final String exp;

    public MulsExp(String exp) {
        this.exp = exp;
    }

    @Override
    public double calculate() {
        String[] split = exp.split("\\*");
        double result = 1;
        for (int i = 0; i < split.length; i++) {
            result *= Double.parseDouble(split[i]);
        }
        return result;
    }
}
