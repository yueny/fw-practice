package com.yueny.fw.practice.design.iterator;

import com.yueny.fw.practice.design.iterator.core.Iterator;

/**
 * 测试类
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-16 14:09
 */
public class IteratorMain {
    public static void main(String[] args) {
        ChineseFoodMenu chineseFoodMenu = new ChineseFoodMenu();
        chineseFoodMenu.add("宫保鸡丁");
        chineseFoodMenu.add("孜然羊肉");
        chineseFoodMenu.add("水煮鱼");
        chineseFoodMenu.add("北京烤鸭");

        Iterator iterator = chineseFoodMenu.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
