package com.yueny.fw.practice.base;

import java.util.Hashtable;

/**
 * 在Java 5中，在Integer的操作上引入了一个新功能来节省内存和提高性能。整型对象通过使用相同的对象引用实现了缓存和重用。
 *     适用于整数值区间-128 至 +127。
 *     只适用于自动装箱。使用构造函数创建对象不适用。
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-18 15:45
 */
public class IntergerMain {
    public static void main(String[] args) {
        /**
         * 输出结果：
         * integer1 == integer2
         * integer3 != integer4
         */
        Integer integer1 = 3;
        Integer integer2 = 3;

        if (integer1 == integer2) {
            System.out.println("integer1 == integer2");
        }else {
            System.out.println("integer1 != integer2");
        }

        Integer integer3 = 300;
        Integer integer4 = 300;

        if (integer3 == integer4) {
            System.out.println("integer3 == integer4");
        }else {
            System.out.println("integer3 != integer4");
        }
    }
}
