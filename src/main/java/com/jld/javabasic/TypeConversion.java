package com.jld.javabasic;

public class TypeConversion {
    private byte a = 127;//1,2^7-1
    private short b = 32767;//2,2^15-1
    private int c = 2147483647;//4,2^31-1
    private long d = 9223372036854775807L;//8,2^63-1
    private float e = 12.36f;//4
    private double f = 23.56;//8
    private char g = '\uffff';//2
    private boolean h = true;//4
    //补码
    //
    //    Java中的Boolean类型是没有给出精确的定义，而在《Java虚拟机规范》给出了Boolean类型是4个字节，和Boolean数组是1个字节的定义，具体还要看虚拟机实现是否按照规范来，所以说1个字节和4个字节都是有可能的。

    public TypeConversion() {

    }

    @Override
    public String toString() {
        return "TypeConversion{" +
                "byte a=" + a +
                ",short b=" + b +
                ",int c=" + c +
                ",long d=" + d +
                ",float e=" + e +
                ",double f=" + f +
                ",char g=" + (short) g +
                ",boolean h=" + h +
                '}';
    }

    public void byteConversion(byte a) {
        this.a = a;//byte
        this.b = a;//short
        this.c = a;//int
        this.d = a;//long
        this.e = a;//float
        this.f = a;//double
        this.g = (char) a;//char，需要强制类型转换
        //this.h = a;//boolean，无法强制类型转换
        System.out.println(this);
    }

    public void shortConversion(short b) {
        this.a = (byte) b;//byte
        this.b = b;//short
        this.c = b;//int
        this.d = b;//long
        this.e = b;//float
        this.f = b;//double
        this.g = (char) b;//char，需要强制类型转换
        //this.h = b;//boolean，无法强制类型转换
        System.out.println(this);
    }

    public void intConversion(int c) {
        this.a = (byte) c;//byte
        this.b = (short) c;//short
        this.c = c;//int
        this.d = c;//long
        this.e = c;//float
        this.f = c;//double
        this.g = (char) c;//char
        //this.h = c;//boolean，无法强制类型转换
        System.out.println(this);
    }

    public void longConversion(long d) {
        this.a = (byte) d;//byte
        this.b = (short) d;//short
        this.c = (int) d;//int
        this.d = d;//long
        this.e = d;//float
        this.f = d;//double
        this.g = (char) d;//char
        //this.h = d;//boolean，无法强制类型转换
        System.out.println(this);
    }

    public void floatConversion(float e) {
        this.a = (byte) e;//byte
        this.b = (short) e;//short
        this.c = (int) e;//int
        this.d = (long) e;//long
        this.e = e;//float
        this.f = e;//double
        this.g = (char) e;//char
        //this.h = e;//boolean，无法强制类型转换
        System.out.println(this);
    }

    public void doubleConversion(double f) {
        this.a = (byte) f;//byte
        this.b = (short) f;//short
        this.c = (int) f;//int
        this.d = (long) f;//long
        this.e = (float) f;//float
        this.f = f;//double
        this.g = (char) f;//char
        //this.h = f;//boolean，无法强制类型转换
        System.out.println(this);
    }

    public void charConversion(char g) {
        this.a = (byte) g;//byte
        this.b = (short) g;//short
        this.c = g;//int
        this.d = g;//long
        this.e = g;//float
        this.f = g;//double
        this.g = g;//char
        //this.h = g;//boolean，无法强制类型转换
        System.out.println(this);
    }

    public void booleanConversion(boolean h) {
        //this.a = h;//byte，无法强制类型转换
        //this.b = h;//short，无法强制类型转换
        //this.c = h;//int，无法强制类型转换
        //this.d = h;//long，无法强制类型转换
        //this.e = h;//float，无法强制类型转换
        //this.f = h;//double，无法强制类型转换
        //this.g = h;//char，无法强制类型转换
        this.h = h;//boolean
        System.out.println(this);
    }


    public static void main(String[] args) {
        //引用类型参与转换无意义，基本数据类型会被封装为包装类，但是一般而言，在不讨论继承关系的情况下，不同引用类型不能自动转换
        TypeConversion typeConversion = new TypeConversion();
        typeConversion.byteConversion((byte) 127);
        typeConversion.shortConversion((short) 32767);
        typeConversion.intConversion(2147483647);
        typeConversion.longConversion(9223372036854775807L);
        typeConversion.floatConversion(12.36f);
        typeConversion.doubleConversion(23.56);
        typeConversion.charConversion('\uffff');
        typeConversion.booleanConversion(true);



    }
}