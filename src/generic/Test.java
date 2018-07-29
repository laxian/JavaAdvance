package generic;

import java.lang.reflect.TypeVariable;

public class Test<T> {
    public static void main(String[] args) {
        Test t = new Test();
        Class<? extends Test> c = t.getClass();
        System.out.println(c.getName());         //输出Test

        TypeVariable<? extends Class<? extends Test>>[] typeParameters = c.getTypeParameters();
        System.out.println();
//        System.out.println(typeParameters.length);
        if (typeParameters != null && typeParameters.length>0) {
            System.out.println(typeParameters[0]);
        }

        Class<?> componentType = c.getComponentType();
        if (componentType != null) {
            System.out.println(componentType.getName());
            System.out.println(componentType.getTypeName());
        }

    }
}