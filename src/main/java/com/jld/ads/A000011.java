package com.jld.ads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 基本读取操作
 */
public class A000011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(",");

        double num1 = Double.parseDouble(tmp[4 - 1]);
        double num2 = Double.parseDouble(tmp[7 - 1]);
        System.out.println(num1);
        System.out.println(num2);
        try {
            System.out.println(Math.round(num1 / num2 * 100) * 0.01d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
