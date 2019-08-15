package com.yueny.fw.practice.map.hashmap;

import com.yueny.rapid.lang.util.time.DurationTimer;

import java.util.HashMap;

/**
 * HashMap 负载因子loadFactor 测试案例
 *
 * 输入 eg
 * <pre>
 *      map 耗时(ms): 7668
 *      map2 耗时(ms): 2890
 *      map3 耗时(ms): 2393
 *      map4 耗时(ms): 466
 *      map5 耗时(ms): 231
 * </pre>
 */
public class LoadFactorHashMap {
    public static void main(String[] args) {
        int size = 5000000;

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(16,100);
        HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>(16,0.5f);
        HashMap<Integer,Integer> map3 = new HashMap<Integer,Integer>(100);
        HashMap<Integer,Integer> map4 = new HashMap<Integer,Integer>();
        // 大数据量下(size)， 初始化容量对性能的影响(扩容)
        HashMap<Integer,Integer> map5 = new HashMap<Integer,Integer>(5000000);

        DurationTimer dt = new DurationTimer();
        for(int i = 0 ; i<size; i++){
            map.put(i, i);
        }
        System.out.println("map 耗时(ms): " + dt.duration());
        map.clear();

        DurationTimer dt2 = new DurationTimer();
        for(int i = 0 ; i<size; i++){
            map2.put(i, i);
        }
        System.out.println("map2 耗时(ms): " + dt2.duration());
        map2.clear();

        DurationTimer dt3 = new DurationTimer();
        for(int i = 0 ; i<size; i++){
            map3.put(i, i);
        }
        System.out.println("map3 耗时(ms): " + dt3.duration());
        map3.clear();

        DurationTimer dt4 = new DurationTimer();
        for(int i = 0 ; i<size; i++){
            map4.put(i, i);
        }
        System.out.println("map4 耗时(ms): " + dt4.duration());
        map4.clear();

        DurationTimer dt5 = new DurationTimer();
        for(int i = 0 ; i<size; i++){
            map5.put(i, i);
        }
        System.out.println("map5 耗时(ms): " + dt5.duration());
        map5.clear();
    }

}
