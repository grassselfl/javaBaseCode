package com.jld.ads;

/**
 * Leetcode 53. 最大子数组和
 */
public class A000024 {
    /**
     * 动态规划，最大子数组和
     * @param nums int
     * @return int
     */
    public int maxSubArray(int[] nums) {
        //dp[i]=max{dp[i-1]+nums[i],nums[i]}

        int[] dp = new int[nums.length];
        int result = dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        //for (int i = 0; i < nums.length; i++) max = Math.max(max, dp[i]);
        return result;
    }

    /**
     * 后续优化，滚动数组思想
     * @param nums int
     * @return int
     */
    public int maxSubArray1(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
