package com.yueny.fw.practice.map.hashmap;

import org.springframework.util.Assert;


/**
 * HashMap 取模原理
 */
public class ModHashMap {
    public static void main(String[] args) {
        String val = "dsf还是大dfbhdf电饭锅和地方";

        int hash = hash(val);

        /**
         * (n - 1) & hash 计算key将被放置的槽位.
         * (n - 1) & hash 本质上是hash % n，位运算更快.
         */
        // n 的赋值来自 n = tab.length， 即数组长度
        Assert.isTrue(((16 - 1) & 15) == 15);
        Assert.isTrue(((16 - 1) & 16) == 0);
        Assert.isTrue(((16 - 1) & 18) == 2);

        Assert.isTrue(((16 - 1) & hash) > 0);
        System.out.println(hash + "取模结果： " + ((16 - 1) & hash));
    }

    /**
     * 见 HashMap#hash() 方法
     * @param key
     * @return
     */
    private static int hash(Object key) {
        int h;
        // 让高位码产生作用: https://www.zhihu.com/question/20733617
        //计算key的hashCode, h = Objects.hashCode(key)
        //h >>> 16表示对h无符号右移16位，高位补0，然后h与h >>> 16按位异或
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
