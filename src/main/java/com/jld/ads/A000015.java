package com.jld.ads;

import java.util.HashMap;

/**
 * 抵消法
 * 算法题：找出数组中出现次数大于数组长度一半、N/K的数
 * 时间复杂度O(n)、空间复杂度O(1)
 *
 * 进阶版
 * 找出数组中出现次数大于数组长度 N/K 的数
 * 要求：时间复杂度为 O(NK)，额外空间复杂度为 O(K)。
 *
 * 分析：
 *
 * 1、一次删除 K 个不同的数，那么你 N 个数，最多能减 N/K次，所以大于 N / K 的数一定会剩下来；
 *
 * 2、给你 K ，最多有 K - 1 个数是大于 N / K 【比如 > N / 4 的最多只有 3 个】，所以保留 K - 1 个候选人即可；
 *
 * 步骤：
 *
 * 1、候选表 HashMap：key为（K - 1）个候选 candiate，value 为它们分别出现的次数;
 *
 * 2、遍历到 arr[i] 时，看 arr[i] 是否在候选人中，如果与某一个候选人相同，就把属于那个候选的点数统计加 1，如果与所有的候选都不相同，先看当前的候选是否选满了，候选表中的大小为 K - 1 个，就是满了；否则就是没有选满。
 *
 * 2.1、如果不满，则把 arr[i] 作为一个新的候选，属于它的点数初始化为 1；
 * 2.2、如果已满，说明此时发现了 k 个不同的数，arr[i] 就是第 k 个。此时把每一个候选各自的点数全部减 1，表示每个候选“付出”一个自己的点数，当前数也不要。如果某些候选的点数在减 1 之后等于 0，则还需要把这些候选人从候选表中删除，候选又变为不满的状态。
 * 在上述过程结束后，还需要再遍历一次，验证被选出来的所有候选有哪些出现次数真的大于 N / K。
 */
public class A000015 {
    public static int[] newData() {
        int[] data1 = {1, 2, 3, 3, 1, 5, 1, 4, 1, 1, 1, 6, 8, 1, 1, 9, 1, 1, 1, 8};
        int[] data2 = {6, 3, 1, 4, 2, 2, 2, 4, 9, 5, 2, 2, 6, 6, 2, 2, 2, 2, 2, 7, 5, 5, 2, 2, 2, 2, 2, 6, 9, 2};
        return data1;
    }

    public static int findMajority(int[] data) {
        int hash = 0, size = 0;
        for (int i : data) {
            if (size == 0) {
                hash = i;
                size = 1;
            } else {
                if (hash == i) size += 1;
                else size -= 1;
            }
        }
        return hash;
    }

    public static void main(String[] args) {
        System.out.println(A000015.findMajority(A000015.newData()));
    }
}
