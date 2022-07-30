package com.jld.javabasic.thread;

public class OutOfMemory {
    public static void main(String[] args) {
        String str = "OutOfMemory";
        try {
            while (true) {
                str += str;
            }
        } catch (Error e) {
            //System.out.println("1221");
            e.printStackTrace();
        }
    }
}