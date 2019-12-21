package algorithm;

// SUM∈[n,6n]，分解成n个数，每个数∈[1,6]，输出所有组合
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
            System.out.println(arr2String(a));
        }
        for (int i = 1; i <= 6; i++) {
            if (!in(s - i, n - 1)) continue;
            if (n > 1) {
                a[CNT - n] = i;
            }
            f(s - i, n - 1, a);
        }
    }

    private static String arr2String(int[] a) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length - 1; i++) {
            sb.append(a[i]).append(", ");
        }
        sb.append(a[a.length - 1]).append("]");
        return sb.toString();
    }

    /**
     * true if s ∈ [n, 6*n]
     */
    static boolean in(int s, int n) {
        return s >= n && s <= 6 * n;
    }
}
