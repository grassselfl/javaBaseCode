package com.jld.javabasic.type;

public class ReferenceConversionQuestion1 {
    static class Animal {
    }

    static class Bird extends Animal {
    }

    public static void main(String[] args) {
        //两个问题
        //1.父类引用指向父类对象是一定不安全还是可能不安全
        Animal animal1 = new Animal();
        //Bird bird1 = (Bird) animal1;//java.lang.ClassCastException: Animal cannot be cast to Bird
        //Casting 'animal1' to 'Bird' will produce 'ClassCastException' for any non-null value

        //答曰必然不安全，除非是父类引用是null
        Animal animal2 = null;
        Bird bird2 = (Bird) animal2;
    }
}



