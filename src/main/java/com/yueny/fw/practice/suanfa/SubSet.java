package com.yueny.fw.practice.suanfa;

import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * 算法：给一个set打印出所有子集
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-11-20 10:01
 */
public class SubSet {
    public static void main(String[] args) {
        // 2^5， 32个子集
        List<String> set = Arrays.asList("1", "2", "3", "4","5");

        printAllSubSet(set);
    }

    public static  void printAllSubSet(List<String> set) {
        int len = set.size();
        int i = 0;

        // 获得所有子集数
        int count = (int) Math.pow(2, len);
        System.out.println("空集 : {}");

        // 输出所有子集
        for (i = 1; i < count; i++) {
            // 十进制转换为二进制输出. 将整数转换成二进制字符串，如果前面为0则会被去掉，比如001,则会显示为1
            String binaryStr = Integer.toBinaryString(i);
            System.out.println("二进制为: " + binaryStr + ", 对应的子集为: ");

            // 二进制字符串的长度
            int binLen = binaryStr.length() - 1;
            // 遍历二进制字符串，(每次遍历输出一个子集)
            for (int j = set.size() - 1; j >= 0 && binLen >= 0; j--, binLen--) {
                // 二进制 数为1的，则输出对应位置的数值
                if (binaryStr.charAt(binLen) == '1') {
                    System.out.print(set.get(j) + " ");
                }
            }
            System.out.println();
            // 开始下一个子集输出
        }
    }
}