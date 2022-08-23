package com.jld.javabasic.string;

public class StringEq {
    public static void main(String[] args) {
        String str1 = new String("abc");
        String str2 = "abc";
        System.out.println(str1 == str2);//false

        String str3 = "abcd";
        String str4 = "abc";
        String str5 = str4 + "d";
        System.out.println(str3 == str5);//false

        String str6 = "123";
        String str7 = "1" + "2" + "3";
        System.out.println(str6 == str7);//true，编译器优化了，直接转化为了123
    }
}
