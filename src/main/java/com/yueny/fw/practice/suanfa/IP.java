package com.yueny.fw.practice.suanfa;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 判断ip是否在给定范围内
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-11-20 10:28
 */
public class IP {
    /**
     * 先将ip地址转换成整数，然后整数比较大小
     *
     * <pre>
     * String[] ips = ip.split("\\.");
     * long ip1 = Integer.parseInt(ips[0]);
     * long ip2 = Integer.parseInt(ips[1]);
     * long ip3 = Integer.parseInt(ips[2]);
     * long ip4 = Integer.parseInt(ips[3]);
     * long ip2long =1L* ip1 * 256 * 256 * 256 + ip2 * 256 * 256 + ip3 * 256 + ip4;
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        String ip = "110.111.112.113";

        Long c = IP2Long(ip);
        System.out.println(c);
    }

    public static long IP2Long(String ip)
    {
        String[] ipBytes = ip.split("\\.");
        System.out.println(Arrays.toString(ipBytes));

        // 进制运算
        double num = 0;
        if(!StringUtils.isEmpty(ip))
        {
            for (int i = ipBytes.length - 1; i >= 0; i--) {
                num += ((Integer.parseInt(ipBytes[i]) % 256) * Math.pow(256, (3 - i)));
            }
        }

        //或者 A.B.C.D，转换成整数只需要将D左移0位（不需要移动），C左移8位，B左移16位，A左移24位即可。
        long ipl = (Long.parseLong(ipBytes[0])<<24)+(Long.parseLong(ipBytes[1])<<16)
                +(Long.parseLong(ipBytes[2])<<8)+(Long.parseLong(ipBytes[3]));
        System.out.println(ipl);

        /**
         * 如果要将整数转换成ip地址，该怎么操作呢？
         *
         * 对于整数X=1852797041，其对应的二进制可以记为ABCD，每个字母表示8位，只需将X右移24位即可得到A，然后将X中的A部分置为0，右移16位即可得到B，同理得到C和D，用“.”连接起来即可。
         *
         * <pre>
         *     		long ipl =1852797041l;
         *
         * 		long A = ipl>>24;
         * 		long B = (ipl&0x00FFFFFF)>>16;
         * 		long C = (ipl&0x0000FFFF)>>8;
         * 		long D = ipl&0x000000FF;
         *
         * 		String ip = new StringBuffer().append(A).append(".").append(B).append(".")
         * 				.append(C).append(".").append(D).toString();
         * 		System.out.println(ip);
         * </pre>
         *
         */
        return (long)num;
    }
}
