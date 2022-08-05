package com.jld.ads;

/**
 * 算法题：二分查找及其拓展延申
 * https://leetcode.cn/problems/binary-search/
 */
public class A000026 {
    public static int binarySearch(int[] nums, int low, int high, int n) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (n < nums[mid]) high = mid - 1;
            else if (n > nums[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }


    public static int[] newData() {
        int[] data1 = {1, 3, 4, 6, 7, 9, 11, 13, 15, 18};
        int[] data2 = {1, 3, 4, 6, 7, 9, 11, 13, 15, 18};
        return data1;
    }

    public static void main(String[] args) {
        int[] data = newData();
        System.out.println(binarySearch(data, 0, data.length - 1, 11));
    }
}
