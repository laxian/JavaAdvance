package proxy;

import java.lang.reflect.Proxy;

/**
 * Created by leochou on 2018/7/29.
 */
public class Utils {

    public static <T> T getProxy(Class<T> service, Object target) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class[]{service}, new DynamicProxy(target));
    }
}
