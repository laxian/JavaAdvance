package algorithm.exp.oper;

public interface Oper {
    double apply(double n1, double n2);

    interface Factory {
        Oper create(String s);
    }

    class Parser implements Factory {

        @Override
        public Oper create(String s) {
            switch (s) {
                case "+":
                    return new AddOper();
                case "-":
                    return new SubOper();
                case "*":
                    return new MulOper();
                case "/":
                    return new DivOper();
            }
            return null;
        }
    }
}
