package com.jld.ads;

import java.util.Arrays;

/**
 * Top-k问题，排序然后选出Top-k,BFPRT
 */
public class A000020 {
    // https://www.cnblogs.com/samuelzhou/p/14965108.html
    // 在 left,right 范围上，找到从小到大排序为 p 的数，即为第 p+1 小的数
    public static int bfprt(int[] arr, int left, int right, int p) {
        if (left == right) return arr[left];
        // bfprt算法：选择中位数数组中的中位数来作为基准划分原数组，可以每次确定甩掉 3N/10 的数据量
        int num = medianOfMedians(arr, left, right);
        int[] index = partition(arr, left, right, num);
        if (p >= index[0] && p <= index[1]) return arr[p];
        else if (p < index[0]) return bfprt(arr, left, index[0] - 1, p);
        else return bfprt(arr, index[1] + 1, right, p);
    }

    // 求中位数数组中的中位数
    public static int medianOfMedians(int[] arr, int left, int right) {
        int num = right - left + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];  // 中位数数组
        int index = 0;
        for (int i = left; i < right; i = i + 5) {
            // 从1开始，而不是从0开始
            Arrays.sort(arr, i, Math.min(right, i + 4)); //需要一个内部排序算法
            mArr[index++] = arr[(i + Math.min(right, i + 4)) / 2]; //中位数数组
        }
        return bfprt(mArr, 0, mArr.length - 1, mArr.length / 2);//递归调用bfprt获取arr.length/2位置的数最终获得一个最坏情况37的中值
    }

    // 根据数num作为基准对数组arr上left到right的范围进行划分（快排/荷兰国旗）
    public static int[] partition(int[] arr, int left, int right, int num) {
        int less = left - 1, more = right + 1;
        while (left < more) {
            if (arr[left] < num) swap(arr, ++less, left++);
            else if (arr[left] > num) swap(arr, --more, left);
            else left++;
        }
        return new int[]{++less, --more};
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] newData() {
        int[] data1 = {1, 6, 2, 3, 8, 5, 4, 7, 9, 10, 13, 12, 16, 15, 14, 11};
        int[] data2 = {1, 6, 2, 3, 8, 5, 4, 7, 9, 10, 13, 12, 16, 15, 14, 11};
        return data1;
    }

    public static void main(String[] args) {
        int[] data = newData();
        //返回从小到大，位于 k-1 位置的数字，就是第 k 大的数
        int k = 7;
        System.out.println(bfprt(data, 0, data.length - 1, k - 1));
    }
}
