package com.yueny.fw.practice.reverse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 列表反序
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-04 15:48
 */
public class ListReverse {
    public static void main(String[] args) {
        /**
         * [ramer, jelly, bean, cake]
         *
         * 	[cake, bean, jelly, ramer]
         * 	[cake, bean, jelly, ramer]
         */
        String[] strings = { "ramer", "jelly", "bean", "cake" };
        System.out.println("\t" + Arrays.toString(strings));

        List newList = Arrays.asList(strings);
        Collections.reverse(newList);
        System.out.println("\t" + Arrays.toString(strings));
        System.out.println("\t" + newList);
    }
}
