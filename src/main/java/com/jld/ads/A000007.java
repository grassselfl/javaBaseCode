package com.jld.ads;

public class A000007 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 实现找零方法总数输出
     *
     * @param N int整型 找零金额
     * @return int整型
     */
    public int GiveChargeSum(int N) {
        //1,2,5,10
        //dp[i],金额为i时由dp[i]种方式
        //dp[i]= dp[i-1] + dp[i-2] + dp[i-5] + dp[i-10]
        int[] dp = new int[N + 1];
        int[] money = {1, 2, 3, 10};
        dp[0] = 1;
        for (int i = 1; i < N + 1; i++) {

            for (int k : money) {
                dp[i] += i - k >= 0 ? dp[i - k] : 0;

            }
            System.out.println(dp[i]);
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(new A000007().GiveChargeSum(37));
    }
}
