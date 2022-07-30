package com.jld.javabasic;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;

/**
 * 一个固定大小的FIFO替换策略的缓存
 * @param <K>
 * @param <V>
 */
public class FIFOCache<K, V> extends LinkedHashMap<K, V> {
    private final int cacheSize;

    public FIFOCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    // 当Entry个数超过cacheSize时，删除最老的Entry
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        WeakHashMap weakHashMap;
        return size() > cacheSize;
    }
}
