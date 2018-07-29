package generic;

import java.lang.reflect.*;
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
            Field[] declaredFields = ParameterizedTypeTest.class.getDeclaredFields();

            for (int i = 0; i < declaredFields.length; i++) {
                Field f = declaredFields[i];
                String fName = f.getName();

                Field list = ParameterizedTypeTest.class.getDeclaredField(fName);
                Type genericType = list.getGenericType();
                System.out.println();
                System.out.println(fName+" -->");
                System.out.println(genericType.getTypeName());
                System.out.println(genericType.getClass().getName());

                if (genericType instanceof ParameterizedType) {
                    testParameterizedType((ParameterizedType) genericType);
                } else if (genericType instanceof TypeVariable) {
                    testTypeVariable((TypeVariable) genericType);
                } else if (genericType instanceof GenericArrayType) {
                    testGenericArrayType((GenericArrayType) genericType);
                } else if (genericType instanceof WildcardType) {
                    testWildCard((WildcardType) genericType);
                }
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private static void testWildCard(WildcardType genericType) {
        Type[] lowerBounds = genericType.getLowerBounds();
        Type[] upperBounds = genericType.getUpperBounds();
        System.out.println(lowerBounds);
        System.out.println(upperBounds);
    }

    private static void testGenericArrayType(GenericArrayType genericType) {
        System.out.println("----");
        Type genericComponentType = genericType.getGenericComponentType();
        System.out.println(genericComponentType.getTypeName());
        if (genericComponentType instanceof ParameterizedType) {
            System.out.println(((ParameterizedType) genericComponentType).getRawType());
            System.out.println(((ParameterizedType) genericComponentType).getActualTypeArguments()[0]);
        }
    }

    private static void testTypeVariable(TypeVariable genericType) {
        System.out.println(genericType.getBounds().length);
        if (genericType.getBounds().length>0) {
            System.out.println(genericType.getBounds()[0]);
        }
    }

    private static void testParameterizedType(ParameterizedType genericType) {
        System.out.println(genericType.getOwnerType());
        // eg: List<T> -> List
        System.out.println(genericType.getRawType());
        Type[] actualTypeArguments = genericType.getActualTypeArguments();
        for (int i = 0; i < actualTypeArguments.length; i++) {
            System.out.println(actualTypeArguments[i].getClass());
            if (actualTypeArguments[i] instanceof WildcardType) {
                testWildCard((WildcardType) actualTypeArguments[i]);
            }
        }
    }
}
