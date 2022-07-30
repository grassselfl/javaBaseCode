package com.jld.ads;

/**
 * 算法题：括号匹配
 */
public class A000001 {

    public static int cal(int k) {
        //(()),()()
        int[] dp = new int[k + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= k; i++) {//i组括号
            dp[i] = 0;
            for (int j = 1; j <= i; j++) {//最外面j个括号
                dp[i] = dp[i] + dp[i - j];
            }
        }
        //(())(())
        return dp[k];
    }
//    void print(int k){
//        for (int i = k; i >= 1; i++) {
//            for (int j=k;){
//
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(cal(3));
    }
    //()()()
    //(())()
    //()(())
    //((()))
}