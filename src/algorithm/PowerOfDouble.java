package algorithm;

/**
 * Created by leochou on 2019/10/20.
 */
public class PowerOfDouble {


    public static double power(double base, int exponent) {
        if (base == 0)
            return 0;
        if (exponent == 0)
            return 1;
        if (exponent == 1)
            return base;
        if (base == 1)
            return base;
        if (base == -1)
            return exponent > 0 ? 1 : -1;
        double result = 1.0;
        boolean posi = exponent > 0;
        int pow = posi ? exponent : (-exponent);
        for (int i = 0; i < pow; i++) {
            result *= base;
        }
        return posi ? result : (1 / result);
    }
    public static void main(String[] args) {
        System.out.println(power(-2.0, 3));
    }
}