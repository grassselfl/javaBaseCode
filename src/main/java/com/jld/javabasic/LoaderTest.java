package com.jld.javabasic;

class Test1 {
    static {
        System.out.println("Test1静态初始化块执行了！");
    }
}

class Test2 {
    static {
        System.out.println("Test2静态初始化块执行了！");
    }
}

class Test3 {
    static {
        System.out.println("Test3静态初始化块执行了！");
    }
}

public class LoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = LoaderTest.class.getClassLoader();
        System.out.println(loader);

        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
        loader.loadClass("Test1");

        //使用Class.forName()来加载类，默认会执行初始化块
        Class.forName("Test2");

        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
        Class.forName("Test3", false, loader);
    }
}