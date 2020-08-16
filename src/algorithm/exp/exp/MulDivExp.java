package algorithm.exp.exp;

public class MulDivExp implements Exp {

    private final String exp;

    public MulDivExp(String exp) {
        this.exp = exp;
    }

    @Override
    public double calculate() {
        String[] split = exp.split("[*]");
        double result = 1;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.contains("/")) {
                result *= new DivsExp(s).calculate();
            } else {
                result *= Double.parseDouble(s);
            }
        }
        return result;
    }
}
