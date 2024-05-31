package com.jld.ads;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/
 */
public class A000027 {

    public static int[] newData() {
        int[] data1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] data2 = {1, 3, 4, 6, 7, 9, 11, 13, 15, 18};
        return data1;
    }

    public static int maxSubArray(int[] nums) {

        // 1.状态转移方程
        // 2.边界条件
        // 3.最优子结构
        // 4.赋予初值
        // 5.开状态转移数组
        // dp[n] = max{dp[n] + nums[n+1], nums[n+1}
    }
}
