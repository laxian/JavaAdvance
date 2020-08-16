package algorithm.exp.exp;

import algorithm.exp.oper.AddOper;
import algorithm.exp.oper.Oper;
import algorithm.exp.oper.SubOper;

public class SizeExp implements Exp {

    private final String exp;
    private final String MUL_EXP = "^\\d+(\\.\\d+)?\\*\\d+(\\.\\d+)?$";
    private final String DIV_EXP = "^\\d+(\\.\\d+)?/\\d+(\\.\\d+)?$";
    private final String ADD_EXP = "^\\d+(\\.\\d+)?\\+\\d+(\\.\\d+)?$";
    private final String SUB_EXP = "^\\d+(\\.\\d+)?-\\d+(\\.\\d+)?$";

    SizeExp(String exp) {
        this.exp = exp;
    }

    @Override
    public double calculate() {
        System.out.println("calculate: " + exp);
        checkFormat();
        if (exp.contains("+")) {
            return doOper(new AddOper(), "\\+");
        } else if (exp.contains("-")) {
            return doOper(new SubOper(), "-");
        } else if (exp.contains("*") && !exp.contains("/")) {
            return new MulsExp(exp).calculate();
        } else if (exp.contains("/") && !exp.contains("*")) {
            return new DivsExp(exp).calculate();
        } else {
            return new MulDivExp(exp).calculate();
        }
    }

    private void checkFormat() {

    }

    private double doOper(Oper oper, String splitter) {
        String[] split = exp.split(splitter);
        double result = 0;
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            try {
                double aDouble = Double.parseDouble(s);
                result = oper.apply(result, aDouble);
            } catch (NumberFormatException e) {
//                e.printStackTrace();
                if (s.matches(ADD_EXP)) {
                    result = oper.apply(result, new AddExp(s).calculate());
                } else if (s.matches(SUB_EXP)) {
                    result = oper.apply(result, new SubExp(s).calculate());
                } else if (s.matches(MUL_EXP)) {
                    if (i == 0) {
                        result = new MulExp(s).calculate();
                    } else {
                        result = oper.apply(result, new MulExp(s).calculate());
                    }
                } else if (s.matches(DIV_EXP)) {
                    result = oper.apply(result, new DivExp(s).calculate());
                } else {
                    result = oper.apply(result, new SizeExp(s).calculate());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new SizeExp("4.0/2.0*3.0/1.0+1.0/2.0").calculate());
        System.out.println(new SizeExp("5*(1+2)").calculate());
    }
}
