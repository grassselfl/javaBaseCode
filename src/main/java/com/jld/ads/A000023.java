package com.jld.ads;

/**
 * 斐波那契数列
 */
public class A000023 {
    /**
     * 递归
     *
     * @param n int
     * @return int
     */
    public static int fib(int n) {
        return n < 2 ? n : fib(n - 1) + fib(n - 2);
    }

    public int fib1(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        //dp[i] = dp[i-1] + dp[i-2]
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // 1.确定状态，开dp
    // 2.状态转移方程
    // 3.边界条件
    // 4.dp计算
    //滚动数组思想
    public int fib2(int n) {
        // 滚动数组优化
        if (n < 2) return n;
        int[] dp = {0, 1};
        for (int i = 2, temp = 0; i <= n; i++) {
            temp = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }

    /**
     * %优化
     * @param n int
     * @return int
     */
    public int fib3(int n) {
        // dp[i] = dp[i-1] + dp[i-2]
        if (n <= 1) return n;
        int[] dp = {0, 1};
        for (int i = 2; i <= n; i++) dp[i % 2] = dp[0] + dp[1];
        return dp[n % 2];
    }

    /**
     * 数学公式
     *
     * @param n int
     * @return int
     */
    public int fib4(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

    /**
     * 枚举
     *
     * @param n int
     * @return int
     */
    int fib5(int n) {
        int[] nums = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040};//31
        return nums[n];
    }
}
