package com.jld.ads;

import java.util.Arrays;

/**
 * 算法题：划分为k个相等的子集
 * 状态压缩动态规划，SCDP
 */
public class A000025 {
    public static int[][] newData() {
        int[] data1 = {3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269};
        int[] k = {5};
        int[][] data3 = {data1, k};
        int[][] data4 = {data1, k};
        return data3;
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        if (k == 1) return true;
        int len = nums.length, sum = 0;
        System.out.println(len);
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[len - 1] > target) return false;

        int size = 1 << len;//1左移len位
        boolean[] dp = new boolean[size];
        dp[0] = true;
        int[] currentSum = new int[size];
        for (int i = 0; i < size; i++) {
            if (!dp[i]) continue;// 总是基于 dp[i] = true 的前提下进行状态转移
            // 基于当前状态，添加一个数以后
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) continue;//==0说明是在添加数字
                int next = i | (1 << j);
                if (dp[next]) continue;
                if ((currentSum[i] % target) + nums[j] <= target) {
                    currentSum[next] = currentSum[i] + nums[j];
                    dp[next] = true;
                } else break;// 由于数组已经排好序，如果 (currentSum[i] % target) + nums[j] > target，剩下的数就没有必要枚举
            }
        }
        return dp[size - 1];
    }

    public static void main(String[] args) {
        int[][] data = newData();
        System.out.println(canPartitionKSubsets(data[0], data[1][0]));
        // 或许再使用遍历回溯可以深入理解这个问题
    }
}
