package com.yueny.fw.practice.bloom;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * 布隆过滤器
 *
 * bloomfilter就类似于一个hash set，用于快速判某个元素是否存在于集合中，
 * 其典型的应用场景就是快速判断一个key是否存在于某容器，不存在就直接返回。
 * 布隆过滤器的关键就在于hash算法和容器大小。
 *
 *
 *
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-17 10:14
 */
public class BloomFilterMain {
    /**
     * 过滤器中存放的初始数据量
     */
    private static final int capacity = 1000000;

    private static final int key = 999998;

    private static BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), capacity);

    static {
        for (int i = 0; i < capacity; i++) {
            bloomFilter.put(i);
        }
    }

    public static void main(String[] args) {
        /*返回计算机最精确的时间，单位微妙*/
        long start = System.nanoTime();

        // 存在，会被匹配到
        if (bloomFilter.mightContain(key)) {
            System.out.println("成功过滤到" + key);
        }
        long end = System.nanoTime();
        System.out.println("布隆过滤器消耗时间:" + (end - start));

        // 错判的数量
        int sum = 0;
        // 模拟 1w 个不存在于布隆过滤器中的key
        for (int i = capacity + 20000; i < capacity + 30000; i++) {
            if (bloomFilter.mightContain(i)) {
                sum = sum + 1;
            }
        }
        System.out.println("错判数为:" + sum);
    }

}
