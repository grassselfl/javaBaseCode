package com.jld.ads;

public class A000014 {
    // i=0，两个线程分别对i进行++100次，i值范围为2-200
    // 解析：正常为200，最小情形如下：
    // 1）两个皆将i=0写入线程内存
    // 2）A线程加至99次写回i=99
    // 3）B线程加至1写回i=1
    // 4）A线程读入i=1
    // 5）B线程读入i=1并加至第100次写回i=100
    // 6）A线程加至第100次写回i=2
}
