package com.jld.designpattern;

public class _1_SingleTon {
    /*枚举特点：
	1. 枚举enum是一个特殊的Java类。它继承自java.lang.Enum，继承了非常多Enum的方法。但枚举类是一个不能够被继承的final类
	2. 枚举类能够定义在interface或class中。当然枚举类型中有构造函数、方法、数据域.

	枚举类中的够早期和普通类的构造器有些不同：
	(a). 构造器仅仅是在构造枚举值的时候被调用
	(b). 构造器仅仅能私有，这样能够保证外部代码无法新构建枚举类的实例

	全部枚举类继承了Enum的方法，以下是这些方法使用介绍：
	(a). ordinal()  返回枚举值在枚举种类的顺序，这个顺序依据枚举值声明的顺序
	(b). compareTo()  Enum实现了java.lang.Comparable接口。它返回的是两个枚举值的顺序之差，但这两个枚举值必须属于同一个枚举类
	(c). values   返回一个包括所有枚举值的数组
	(d). toString  返回枚举常量的名称
	(e). valueOf  类似toString
	(f). equals   比較两个枚举类对象的应用*/

    //基于Enum的单例模式是其最佳设计
    public enum Singleton {
        INSTANCE;
        public void doSomething() {
            System.out.println("doSomething");
        }

    }

    public static void main(String[] args) {
        Singleton.INSTANCE.doSomething();
        example();
    }


    public static void example(){
        System.out.println(Runtime.getRuntime());//单例模式例子之一
    }



}
