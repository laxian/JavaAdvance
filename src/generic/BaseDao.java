package generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class BaseDao<T> {

    private Class<T> clszz;

    public BaseDao(){
        Type type = this.getClass().getGenericSuperclass();//拿到带类型参数的泛型父类
        if(type instanceof ParameterizedType){//这个Type对象根据泛型声明，就有可能是4中接口之一，如果它是BaseDao<User>这种形式
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();//获取泛型的类型参数数组
            if(actualTypeArguments != null && actualTypeArguments.length == 1){
                if(actualTypeArguments[0] instanceof Class){//类型参数也有可能不是Class类型
                    this.clszz = (Class<T>) actualTypeArguments[0];
                }else{
                    //例如： generic.BaseDao<generic.BaseDao<User>>,获取到的就不是Class,而又是ParameterizedType，即嵌套的
//                    ParameterizedType，一层一层剥开，最终是可以得到User的Class对象的
                }
            }
        }
    }

}
