package com.jld.ads;

import java.util.ArrayList;

public class A000012 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * func lengthOfMaxQueue(nums []int) int {
     * return 0
     * }
     *
     * @param nums int整型ArrayList
     * @return int整型
     */
    public int lengthOfMaxQueue(ArrayList<Integer> nums) {

        //计算
        int[] dp = new int[nums.size()];
        dp[0] = 1;
        for (int i = 1; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (nums.get(i) > nums.get(j)) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            if (dp[i] == 0) dp[i] = 1;
        }

        //获取结果
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(181);
        arrayList.add(180);
        arrayList.add(165);
        arrayList.add(175);
        arrayList.add(168);
        arrayList.add(178);
        //[181,180,165,175,168,178]
        System.out.println(new A000012().lengthOfMaxQueue(arrayList));
    }
}
