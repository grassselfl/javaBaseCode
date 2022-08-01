package com.jld.ads;

import java.util.Arrays;

/**
 * 快速排序
 */
public class A000019 {
    public static int[] newData() {
        int[] data1 = {1, 6, 2, 3, 8, 5, 4, 7, 9, 10, 13, 12, 16, 15, 14, 11};
        return data1;
    }


    public static void quickSort(int[] data, int l, int r) {
        int x = data[l], i = l, j = r;//基准数取最左边的
        while (i < j) {//确定基准数的位置
            while (i < j && data[j] >= x) j--; //从右向左找第一个小于x的数
            if (i < j) data[i++] = data[j];//替换序列右边的一个不小于基准值的值
            while (i < j && data[i] < x) i++; //从左向右找第一个大于等于x的数
            if (i < j) data[j--] = data[i];//替换序列左边的一个大于基准值的值
        }
        data[i] = x;//基准数确定位置后的赋值
        if (l < i - 1) quickSort(data, l, i - 1);//左子序列不只有一个元素时递归
        if (i + 1 < r) quickSort(data, i + 1, r);//右子序列不只有一个元素时递归
    }

    public static void main(String[] args) {
        int[] data = newData();
        quickSort(data, 0, data.length - 1);
        for (int i : data) System.out.println(i);
    }
}
