package com.jld.ads;

/**
 * 算法题：LeetCode第698题：将一个整数数组划分为K个相等的子集问题
 */
public class A000022 {
    public static int SIZE = 10000 + 1;

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, size = 0;
        for (int i : nums) sum += i;
        if (sum % k != 0) return false;
        else size = sum / k;
        int[] num = new int[size + 1];
        for (int i : nums) {
            if (i <= size) num[i]++;
            else return false;
        }
        for (int i = 0; i < k; i++) if (!can(num, size)) return false;
        return true;
    }
    public static boolean can(int[] data, int n) {
        if (n == 0) return true;
        int i = n;
        while (i > 0) {
            if (data[i] != 0) {
                data[i] -= 1;
                return can(data, n - i);
            } else {
                --i;
            }
        }
        return false;
    }

    public static int[] newData() {
        int[] data1 = {4, 3, 2, 3, 5, 2, 1};
        int[] data2 = {2,2,2,2,3,4,5};
        return data2;
    }

    public static void main(String[] args) {
        int[] data = newData();
        System.out.println(canPartitionKSubsets(data, 4));
    }
}
