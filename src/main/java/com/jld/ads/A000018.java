package com.jld.ads;

public class A000018 {
    public static int[] newData() {
        int[] data1 = {1, 2, 3, 4, 5, 6, 12, 7, 8, 9, 10};
        return data1;
    }

    public static void changeOrderOfArray(int[] data) {
        int[] newData = new int[data.length];
        int size = 0;
        for(int i:data)if(i%2==1)newData[size++]=i;
        for(int i:data)if(i%2==0)newData[size++]=i;
        System.arraycopy(newData,0,data,0,newData.length);
    }

    public static void main(String[] args) {
        int[] data = A000017.newData();
        A000017.changeOrderOfArray(data);
        for (int i : data) {
            System.out.println(i);
        }
    }
}