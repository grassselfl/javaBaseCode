package com.jld.javabasic;

public class TestCodeDemo {
    public int foo() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(new TestCodeDemo().foo());
    }
}
