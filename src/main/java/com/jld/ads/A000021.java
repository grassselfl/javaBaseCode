package com.jld.ads;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 * 数组形式表达
 * 给定一个整数数组，给定一个值K，这个值在原数组中一定存在
 * 要求把数组中小于K的元素放到数组的左边，大于K的元素放到数组的右边，等于K的元素放到数组的中间
 * 最终返回一个整数数组，其中只有两个值，分别是等于K的数组部分的左右两个下标值
 * <p>
 * less、more很像一个渔网，一直筛一直筛直到只剩下相等的数
 */
public class A000021 {
    public static int[] netherlandsPartition(int[] data, int l, int r, int k) {
        int less = l - 1, more = r + 1;
        while (l < more) {
            if (data[l] > k) swap(data, --more, l);
            else if (data[l] < k) swap(data, ++less, l++);
            else l++;
        }
        return new int[]{++less, --more};//等于边界
    }

    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static int[] newData() {
        int[] data1 = {2, 3, 1, 9, 7, 6, 4, 4, 5};
        int[] data2 = {2, 3, 1, 9, 7, 6, 1, 4, 5};
        return data1;
    }

    public static void main(String[] args) {
        int[] data = newData();
        System.out.println(Arrays.toString(netherlandsPartition(data, 0, data.length - 1, 4)));
        System.out.println(Arrays.toString(data));
    }
}
