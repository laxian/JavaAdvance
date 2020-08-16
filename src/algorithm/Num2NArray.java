package algorithm;

import java.util.Arrays;

/** SUM∈[n,6n]，分解成n个数，每个数∈[1,6]，输出所有组合
 *  另一种描述是，n个骰子，正面朝上有几种组合（假设有序）
 */
public class Num2NArray {

    private static int SUM = 9;
    private static int CNT = 3;
    private static int RESULT = 0;

    public static void main(String[] args) {
        int[] a = new int[CNT];
        f(SUM, CNT, a);
        System.out.println(RESULT);
    }

    static void f(int s, int n, int[] a) {
//        if (!in(s, n)) return;
        if (n == 1) {
            RESULT++;
            a[CNT - n] = s;
            System.out.println(Arrays.toString(a));
        }
        for (int i = 1; i <= 6; i++) {
            if (!in(s - i, n - 1)) continue;
            if (n > 1) {
                a[CNT - n] = i;
            }
            f(s - i, n - 1, a);
        }
    }

    /**
     * true if s ∈ [n, 6*n]
     */
    static boolean in(int s, int n) {
        return s >= n && s <= 6 * n;
    }
}
