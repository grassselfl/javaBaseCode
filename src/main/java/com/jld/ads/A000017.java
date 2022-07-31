package com.jld.ads;

/**
 * 算法题：移动
 * 1、要想保证原有的次序，则只能顺序移动或者相邻交换；
 *
 * 2、i 从左到右开始遍历，找到第一个偶数；
 *
 * 3、j 从 i+1 开始向后找，直到找到第一个奇数；
 *
 * 4、将 [ i , ... . j - 1 ] 的元素整体后移一位，最后将找到的奇数放入 i 位置，然后 i++；
 *
 * 5、终止条件，j 向后遍历查找失败，即后面没有奇数了。
 */
public class A000017 {
    public static int[] newData() {
        int[] data1 = {1, 2, 3, 4, 5, 6, 12, 7, 8, 9, 10};
        return data1;
    }

    public static void changeOrderOfArray(int[] data) {
        int left = 0, right;
        while (left < data.length) {
            while (left < data.length && data[left] % 2 != 0) left++;
            right = left + 1;
            while (right < data.length && data[right] % 2 != 1) right++;
            if (right < data.length) {
                int temp = data[right];
                //for (int i = right; i > left; i--) data[i] = data[i - 1];
                System.arraycopy(data, left, data, left + 1, right - left);
                data[left++]=temp;
            }else break;
        }
    }

    public static void main(String[] args) {
        int[] data = A000017.newData();
        A000017.changeOrderOfArray(data);
        for (int i : data) {
            System.out.println(i);
        }
    }
}
