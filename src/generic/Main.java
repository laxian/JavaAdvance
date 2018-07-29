package generic;

import java.lang.reflect.TypeVariable;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        TypeVariable<Class<BaseDao>>[] typeParameters = BaseDao.class.getTypeParameters();
        System.out.println(typeParameters.length);
        if (typeParameters.length > 0) {
            for (int i = 0; i < typeParameters.length; i++) {
                System.out.println(typeParameters[i].getName());
            }
        }
    }
}
