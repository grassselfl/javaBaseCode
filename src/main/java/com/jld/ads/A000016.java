package com.jld.ads;

/**
 *
 */
public class A000016 {
    public static int[] newData() {
        int[] data1 = {1, 2, 3, 4, 5, 6, 12, 7, 8, 9, 10};
        return data1;
    }

    public static void changeOrderOfArray(int[] data) {
        int left = 0, right = data.length - 1;
        while (left < right) {
            while (left < right && data[left] % 2 != 0) left++;
            while (left < right && data[right] % 2 != 1) right--;
            if (left < right) {
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = A000017.newData();
        A000017.changeOrderOfArray(data);
        for (int i : data) {
            System.out.println(i);
        }
    }
    // 要增加扩展性可以将data[left] % 2 != 0写为条件函数，就会成为一个模板，面试官：如果把题目改成数组中的数按照大小分为两部分，所有的负数在所有的非负数的前面，该怎么做？
    //如果再把题目改改，变成把数组中的数分成两部分，能被3整除的数都在不能被3整除的数的前面，怎么办？
}
