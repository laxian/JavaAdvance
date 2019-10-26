package algorithm;

/**
 * Created by leochou on 2019/10/20.
 */
public class OddOvenSort {


    public static void resort(int[] array) {
        //排序：奇数<偶数
        //稳定
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (gt(array[j+1], array[j])) {
                    swap(array, j, j + 1);
//                    array[j]=array[j]+array[j+1];
//                    array[j+1]=array[j]-array[j+1];
//                    array[j]=array[j]-array[j+1];
                }
            }
        }

    }

    public static void swap(int[]arr, int a, int b) {
        arr[a]=arr[a]+arr[b];
        arr[b]=arr[a]-arr[b];
        arr[a]=arr[a]-arr[b];
    }

    public static boolean gt(int a, int b) {
        return a % 2 - b % 2 > 0;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        resort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}