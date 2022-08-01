package com.jld.javabasic;

import java.util.Scanner;

public class _IO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextByte();
        scanner.nextShort();
        scanner.nextInt();
        scanner.nextLong();
        scanner.nextFloat();
        scanner.nextDouble();
        scanner.next();//字符串，以空白为结尾
        scanner.nextLine();//一行以/n为结尾
        scanner.nextBoolean();
        //无nextChar
        scanner.nextBigInteger();
        scanner.nextBigDecimal();
    }
}
