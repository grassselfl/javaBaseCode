package com.jld.ads;

/**
 * 算法题：快速排序
 */
public class A000002 {
    public void quickSort(int l, int r, int[] num) {
        //if(l>=r)return;

        int x = num[l];
        int i = l, j = r;

        while (i < j) {
            while (i < j && num[j] >= x) j--;
            if (i < j) num[i++] = num[j];
            while (i < j && num[i] < x) i++;
            if (i < j) num[j--] = num[i];
        }
        num[i] = x;

        if (l < i - 1) quickSort(l, i - 1, num);
        if (i + 1 < r) quickSort(i + 1, r, num);
    }
}
