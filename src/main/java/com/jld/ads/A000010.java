package com.jld.ads;

import org.testng.annotations.Test;

public class A000010 {

    @Test
    public void Test1() {
        System.out.println(10 * 20 + "QAX");
        System.out.println("QAX" + 10 * 20);
    }

    class A {
        int fun = 1;

        protected void method() {
            System.out.println("A");
        }
    }

    class B extends A {
        int fun = 2;

        @Override
        protected void method() {
            System.out.println("B");
        }
    }

    @Test
    //protected也是向上转型
    public void Test2(){
        A a = new A();
        System.out.println(a.fun);
        a.method();

        A b = new B();
        System.out.println(b.fun);
        b.method();
    }
}
