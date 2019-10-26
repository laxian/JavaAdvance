package algorithm;

/**
 * Created by leochou on 2019/10/20.
 */
public class Fibonacci {
    public static int fibonacci(int n) {
        //0112358
        int x = 0, y = 1;
        if (n == 0)
            return 0;
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(3));
        System.out.println(fibonacci(4));
        System.out.println(fibonacci(5));
    }
}