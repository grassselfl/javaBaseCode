package com.jld.javabasic.string;

import java.util.StringJoiner;

public class StringJoinerDemo {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(", ","[","]");
        stringJoiner.add("a");
        stringJoiner.add("b");
        stringJoiner.add("c").add("d");//支持链式编程
        System.out.println(stringJoiner);
        System.out.println(stringJoiner.length());
    }
}
