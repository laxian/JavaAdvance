package algorithm;

/**
 * Created by leochou on 2019/10/20.
 */
public class NumberOfOne {

    // 没考虑负数，不通过
    public static int fun(int t){
        if (t==1)
            return 1;
        int m = 0;
        while (t>0){
            int n = 1;
            while (n<=t){
                n<<=1;
            }
            t-=n>>1;
            m++;
        }
        return m;
    }

    public static int fun2(int t){
        int m=0;
        while (t!=0){
            t&=(t-1);
            m++;
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(fun2(-2147483648));
    }
}
