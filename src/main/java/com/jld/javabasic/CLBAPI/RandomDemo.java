package com.jld.javabasic.CLBAPI;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }
}
