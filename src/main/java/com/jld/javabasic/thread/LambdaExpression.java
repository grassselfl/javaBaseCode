package com.jld.javabasic.thread;

/**
 * 推导lambda表达式
 */

// 一个函数式接口
interface ILike {
    void lambda(int i);
}

// 1.外部类
class Like1 implements ILike {
    @Override
    public void lambda(int i) {
        System.out.println("I like lambda" + i);
    }
}

public class LambdaExpression {
    //2.静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda(int i) {
            System.out.println("I like lambda" + i);
        }
    }

    public static void main(String[] args) {

        //1.外部类
        ILike like1 = new Like1();
        like1.lambda(1);

        //2.静态内部类
        ILike like2 = new Like2();
        like2.lambda(2);
        //3.局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda(int i) {
                System.out.println("I like lambda" + i);
            }
        }
        ILike like3 = new Like3();
        like3.lambda(3);

        //4.匿名内部类
        ILike like4 = new ILike() {
            @Override
            public void lambda(int i) {
                System.out.println("I like lambda" + i);
            }
        };
        like4.lambda(4);

        //5.lambda表达式，相关写法
        ILike like5 = (int i) -> {
            System.out.println("I like lambda" + i);
        };
        like5.lambda(5);

        ILike like6 = (i) -> {
            System.out.println("I like lambda" + i);
        };
        like6.lambda(6);

        ILike like7 = i -> {
            System.out.println("I like lambda" + i);
        };
        like7.lambda(7);

        ILike like8 = i -> System.out.println("I like lambda" + i);
        like8.lambda(8);
    }
}