package com.jld.ads;

/**
 * 算法题：二分查找、升级版
 */


public class A000004 {

    public static int findA(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static int findB(int[] a, int x) {
        return find(0, a.length - 1, a, x);
    }

    public static int find(int l, int h, int[] a, int x) {
        int low = l, high = h, mid = (low + high) / 2;
        while (low <= high) {
            if (a[mid] == x) return mid;
            else if (x < a[mid]) {
                high = mid - 1;
            } else {//(x > a[mid])
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 6, 11, 12};
        System.out.println(findA(a, 4));
        System.out.println(findB(a, 4));

        System.out.println(findA(a, 5));
        System.out.println(findB(a, 5));

        for (int i = 0; i < a.length; i++) {
            System.out.print(findA(a, a[i]));
        }
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(findB(a, a[i]));
        }
    }
}

