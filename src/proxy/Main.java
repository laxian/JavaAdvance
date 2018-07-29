package proxy;

/**
 * Created by leochou on 2018/7/29.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("begin main");

        ICoder coder = Utils.getProxy(ICoder.class, new Coder());
        coder.programing();
    }
}
