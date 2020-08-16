package algorithm.exp.exp;

public class DivsExp implements Exp {

    private final String exp;

    public DivsExp(String exp) {
        this.exp = exp;
    }

    @Override
    public double calculate() {
        String[] split = exp.split("/");
        double result = 1;
        for (int i = 0; i < split.length; i++) {
            if (i == 0)
                result *= Double.parseDouble(split[i]);
            else
                result /= Double.parseDouble(split[i]);
        }
        return result;
    }
}
