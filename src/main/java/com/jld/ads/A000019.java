package com.jld.ads;

import java.util.Arrays;

/**
 * Top-k问题，排序然后选出Top-k
 */
public class A000019 {
    public static int[] newData() {
        int[] data1 = {1, 6, 2, 3, 8, 5, 4, 7, 9, 10, 13, 12, 16, 15, 14, 11};
        return data1;
    }

    public static int findTopK(int[] data, int k) {
        Arrays.sort(data);
        return data[k - 1];
    }

    public static int quickSort(int[] data,)

    public static void main(String[] args) {
        System.out.println(A000019.findTopK(A000019.newData(), 6));
    }
}
