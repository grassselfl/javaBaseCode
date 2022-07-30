package com.jld.ads;

/**
 * 算法题：斐波那契数列
 */
public class A000003 {
//    F(n)=F(n-1)+F(n-2)
//    F(0)=0 F(1)=1

//    n=50
//    fun(n){
//        int fList[n+1]
//        fList[1]=0,fList[2]=1
//        if 小于等于2,直接返回对应值
//        else {
//            for i from 3 to n
//                fList[i] = fList[i-1] + fList[i-2]
//        }
//    }

    public void fun(int n) {
        long[] fList = new long[n + 1];

        if (n <= 2) {
            System.out.println(n == 1 ? "0" : "0\t1");
        } else {
            fList[1] = 0;
            fList[2] = 1;
            for (int i = 3; i <= n; i++) {
                fList[i] = fList[i - 1] + fList[i - 2];
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(fList[i]);
            if (i % 5 != 0) System.out.print('\t');
            else System.out.print('\n');
        }
    }

    public static void main(String[] args) {
        new A000003().fun(50);
    }
}

