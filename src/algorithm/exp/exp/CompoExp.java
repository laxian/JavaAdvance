package algorithm.exp.exp;

public class CompoExp implements Exp {

    private final String exp;
    private int maxDepth;

    public CompoExp(String exp) {
        this.exp = checkAndFormat(exp);
    }

    private String checkAndFormat(String exp) {
        checkExp(exp);
        return formatExp(exp);
    }

    private String formatExp(String exp) {
        return exp.replaceAll(" ", "").replaceAll("(?<=\\d)\\(", "*(");
    }

    private void checkExp(String exp) {
        String allChars = "[0-9.+\\-*/()\\s]+";
        if (!exp.matches(allChars)) {
            throw new IllegalArgumentException("含有非法字符");
        }
        char[] chars = exp.toCharArray();
        int depth = 0;
        maxDepth = 0;
        for (int i = 0; i < chars.length; i++) {
            if ('(' == (chars[i])) {
                depth++;
                if (depth > maxDepth) maxDepth = depth;
            } else if (')' == chars[i]) {
                depth--;
                if (depth < 0) {
                    throw new IllegalArgumentException(")之前没有(");
                }
            }
        }
        if (depth != 0) {
            throw new IllegalArgumentException(exp + ":  (、)不成对");
        }
    }

    @Override
    public double calculate() {
        System.out.println("calculate: " + exp);
        if (maxDepth == 0) {
            return new SizeExp(exp).calculate();
        } else {
            int start = exp.indexOf("(");
            int end = exp.lastIndexOf(")");
            char[] chars = exp.toCharArray();
            int depth = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '(') depth++;
                if (chars[i] == ')') {
                    depth--;
                    if (depth == 0) {
                        end = i;
                        break;
                    }
                }
            }
            String sub = exp.substring(start, end + 1);
            double replaceValue = 0;
            if (maxDepth == 1) {
                replaceValue = new SizeExp(sub.substring(1, sub.length() - 1)).calculate();
            } else {
                replaceValue = new CompoExp(sub.substring(1, sub.length() - 1)).calculate();
            }
            String exp2 = exp.substring(0, start) + replaceValue + exp.substring(end + 1);
            return new CompoExp(exp2).calculate();
        }
    }

    public static void main(String[] args) {
        String e = "1+ 2(1 +1.1(2+3.0)-1+5(1+1(1+2.1))";
        double c = new CompoExp(e).calculate();
        System.out.println(c);
    }
}
