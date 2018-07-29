package proxy;

/**
 * Created by leochou on 2018/7/29.
 */
public class Coder implements ICoder {
    @Override
    public void programing() {
        System.out.println("I'm a coder from"+this.getClass().getName());
    }
}
