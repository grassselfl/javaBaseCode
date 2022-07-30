package com.jld.ads;

/**
 * 算法题：二分查找进阶
 */
public class A000008 {
    public int findMaxElem(int[] num) {
        int length = num.length;
        if (length == 0) return 0;
        else if (length == 1) return num[0];
        else if (length == 2) return Math.max(num[0], num[1]);
        else if (length == 3) return Math.max(num[0], Math.max(num[1], num[2]));
        else {
            int l = 0, h = length - 1, m = (l + h) / 2;
            while (l < m && m < h) {
                if (num[m - 1] < num[m] && num[m] < num[m + 1]) {
                    l = m;//递增序列较长，截断递增序列
                } else if (num[m - 1] > num[m] && num[m] > num[m + 1]) {
                    h = m;//递减序列较长，截断递减序列
                } else {//中间为峰值
                    return num[m];
                }
                m = (l + h) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5, 4, 3,2,1};
        System.out.println(new A000008().findMaxElem(array));
    }
}
