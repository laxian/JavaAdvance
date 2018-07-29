# java Type

直接子类
-------
* TypeVariable
* GenericArrayType
* ParameterizedType
* WildCardType
* Class

## example

* TypeVariable
形如```<T>```，去掉"<>"只剩下"T"，代表一种变量类型，是最简单的泛型类型

* GenericArrayType
形如：List<T>[]，泛型类型是一个数组

* ParameterizedType
形如：Set<? extends Number>，这是一个ParameterizedType，其内部又包含了一个
WildCardType，即，通配符类型，稍后介绍

* WildCardType
形如<? super User>，或<?>，或<? extends Person>