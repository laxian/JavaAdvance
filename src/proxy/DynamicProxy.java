package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by leochou on 2018/7/29.
 */
public class DynamicProxy implements InvocationHandler {

    private final Object target;

    public DynamicProxy(Object realObject) {
        this.target = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin involk");
        method.invoke(target, args);
        System.out.println("after involk");
        return null;
    }
}
