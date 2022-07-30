package com.jld.javabasic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //实现Callable接口
        class CallableImpl implements Callable<Integer> {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName() + " come in callable");
                Thread.sleep(5000);
                return 200;
            }
        }

        //FutureTask，也可以使用lambda表达式
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableImpl());

        //创建一个线程
        new Thread(futureTask, "mary").start();
        while (!futureTask.isDone()) {
            System.out.println("wait.....");
        }
        //调用FutureTask的get方法，Future，线程调用futureTask.get时，如果没有计算完，该线程会被阻塞

        System.out.println(futureTask.get());

        System.out.println(Thread.currentThread().getName() + " come over");
    }
}