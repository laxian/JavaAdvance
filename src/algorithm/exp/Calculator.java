package algorithm.exp;

import algorithm.exp.exp.CompoExp;

public class Calculator {
    public static void main(String[] args) {
        String e1 = "1+2";                                  // 3
        String e2 = "1+2+3";                                // 6
        String e3 = "1+2+3-4+5";                            // 7
        String e4 = "1+2+3-1+5*2";                          // 15
        String e5 = "1+2+3-1+5(1+1(1+2.1))";                // 25.5
        String e6 = "1+2(1+1.1)-1+5(1+1(1+2.1))";           // 24.7
        String e7 = "1+2(1+1.1(2+3.0))-1+5(1+1(1+2.1))";    // 33.5
        String e8 = "1+ 2(1 +1.1(2+3.0))-1+5(1+1(1+2.1))";   // 33.5 有空格
        String e9 = "1+ 2(1 +1.1(2+3.0))-1+5(1+1*(1+2.1))"; // 33.5 '('前不省略'*'号

        String r1 = "1+2(1+1.1(2+3.0)-1+5(1+1(1+2.1))"; // 少')'
        String r2 = "1+2)1+1.1(2+3.0)(-1+5(1+1(1+2.1))"; // 先出现')'
        String r3 = "1x2(1+1.1(2+3.0)-1+5(1+1(1+2.1))"; // 错误符号'x'
        String[] exps = {e1, e2, e3, e4, e5, e6, e7, e8, e9};
        double[] ans = {3.0, 6.0, 7.0, 15, 25.5, 24.7, 33.5, 33.5, 33.5};
        String[] exps_error = {r1, r2, r3};
        for (int i = 0; i < exps.length; i++) {
            String s = exps[i];
            double a = ans[i];
            double calculate = new CompoExp(s).calculate();
            System.out.println(s + ": " + calculate + " : " + a);
        }

        for (int i = 0; i < exps_error.length; i++) {
            String s = exps_error[i];
            try {
                new CompoExp(s).calculate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
