# java Dynamic Proxy

## 和静态代理的区别
静态代理，在编译器就已经确定了代理和被代理对象。
在Android中，ContextImpl和ContextWrapper，就使用了静态代理。
ContextImpl是Content的实际实现类，ContextWrapper是代理类，也实现了Context，其内部有一个ContextImpl实例:mBase，实际的实现，由mBase完成。

动态代理，是在运行时，动态的生成代理对象

## 动态代理，只能代理接口
Android http 注解框架Retrofit，就是使用动态代理实现的

## cglib也能实现动态代理
cglib能实现动态代理，而且不限于接口，类也可以代理。
