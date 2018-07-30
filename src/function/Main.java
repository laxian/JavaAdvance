package function;

import java.util.function.Function;

/**
 * Created by leochou on 2018/7/30.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("begin main--->");

        Main main = new Main();
        String apply = main.<Integer, String>getClassName().apply(123);
        System.out.println(apply);

        Integer sLen = main.<String, Integer>getLength().apply("hello world");
        System.out.println(sLen);

        Integer sLen2 = main.getLength().apply("hello world");
        System.out.println(sLen2);

        String raw = "I'm laxian";
        System.out.println(raw);

        // a->* ab->** xyz->***
        String stars = main.getLength().andThen(i -> new String(new char[i]).replace("\0", "*")).apply(raw);
        System.out.println(stars);

        String raw2 = "I'm laxian's brother";
        System.out.println(raw2);
        String stars2 = main.<Integer, String>repeat().<String>compose(s->s.length()).apply(raw2);
        System.out.println(stars2);
    }

    public Function<Integer, String> repeat() {
        return i->new String(new char[i]).replace("\0", "*");
    }

    public Function<String, Integer> getLength() {
        return s->s==null?0:s.length();
    }

    public <T, R> Function<T, R> getClassName() {
        return t->(R)t.getClass().getName();
    }
}
