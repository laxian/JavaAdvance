package generic;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

/**
 * Created by leochou on 2018/7/29.
 */
public class ParameterizedTypeTest<T> {

    // ParameterizedType
    List<T> list;
    Set<T> set;

    // TypeVariable
    T data;

    // ParameterizedType, and "? extends T" is a WildCardType
    List<? extends T> child;

    // GenericArrayType
    List<T>[] objs;

    public static void main(String[] args) {
        try {

            String[] fields = {"list", "set", "data", "child", "objs"};

            for (String fName: fields) {

                Field list = ParameterizedTypeTest.class.getDeclaredField(fName);
                Type genericType = list.getGenericType();
                System.out.println();
                System.out.println(fName+" -->");
                System.out.println(genericType.getTypeName());
                System.out.println(genericType.getClass().getName());
                if (genericType instanceof ParameterizedType) {
                    System.out.println(((ParameterizedType) genericType).getOwnerType());

                    // eg: List<T> -> List
                    System.out.println(((ParameterizedType) genericType).getRawType());
                    System.out.println(((ParameterizedType) genericType).getActualTypeArguments()[0].getClass());
                }
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
