package com.yueny.fw.practice.map.hashmap.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * HashMap 测试map从链表转变成红黑树的过程以及扩容
 */
public class TreeNodeHashMap {
    public static void main(String[] args) {
        Map<MapKey,String> map = new HashMap<MapKey, String>();
        //第一阶段， hashCode的值全为 1
        for (int i = 0; i < 6; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }

        //第二阶段， hashCode的值全为 1
        for (int i = 0; i < 10; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }

        //第三阶段， hashCode的值全为 1
        for (int i = 0; i < 50; i++) {
            map.put(new MapKey(String.valueOf(i)), "A");
        }

        //第四阶段， hashCode的值全为 2
        map.put(new MapKey("Z"), "B");
        map.put(new MapKey("J"), "B");
        map.put(new MapKey("F"), "B");
        System.out.println(map);
    }

    /**
     * 重写了hashCode使得hashCode碰撞极高
     */
    static class MapKey {
        private static final String REG = "[0-9]+";

        private String key;

        public MapKey(String key) {
            this.key = key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MapKey mapKey = (MapKey) o;

            return !(key != null ? !key.equals(mapKey.key) : mapKey.key != null);

        }
        /*
         * 确保每次key的hashCode都相同
         */
        @Override
        public int hashCode() {
            if (key == null){
                return 0;
            }

            Pattern pattern = Pattern.compile(REG);
            // 所有数字，hashCode全部给1，为了复现碰撞极高， 且更容易树化(超过8)
            if (pattern.matcher(key).matches()) {
                return 1;
            }else {
                // 非数字
                return 2;
            }
        }

        @Override
        public String toString() {
            return key;
        }
    }

}
