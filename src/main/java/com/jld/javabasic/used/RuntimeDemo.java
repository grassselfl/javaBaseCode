package com.jld.javabasic.used;

import java.io.IOException;

public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("calc");//执行cmd
        System.out.println(runtime.availableProcessors());

        System.out.println(runtime.maxMemory()/1024/1024);//byte，最大
        System.out.println(runtime.totalMemory()/1024/1024);//总
        System.out.println(runtime.freeMemory()/1024/1024);//空闲
        runtime.exit(0);//System.exit底层调用
    }
}
