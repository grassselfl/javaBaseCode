package com.jld.javabasic;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(20);
        for (int i = 0; i < 100; i++) {
            arrayList.add(i % 50);
        }
        System.out.println(arrayList.size());//100
        System.out.println(arrayList);

        arrayList.remove(0);
        System.out.println(arrayList);

        arrayList.add(99, 200);//在该索引处添加，可以等于size，即指向第size+1个位置
        System.out.println(arrayList);

        arrayList.set(0, 0);
        System.out.println(arrayList.get(0));//0

        System.out.println(arrayList.indexOf(23));//22
        System.out.println(arrayList.lastIndexOf(23));//72

        arrayList.clear();
        System.out.println(arrayList);//[]
    }
}