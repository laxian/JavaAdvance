# java Function

JDK 1.8 API包含了很多内建的函数式接口

```java
    // 输入T，输出R
    R apply(T t);
    
    // 首先执行apply，然后再执行传入的Function<R, V>, 也就是，把当前执行结果作为输入，再次执行，输出V
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }
    
    
    // 再执行当前Function前，先执行Function<V, T>，然后将结果作为当前Function<T, R>的输入
    default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
        Objects.requireNonNull(before);
        return (V v) -> apply(before.apply(v));
    }

```