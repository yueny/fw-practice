package com.yueny.fw.practice.suanfa;

import java.util.Scanner;

/**
 * 算法题 硬币组合问题
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-11-18 19:53
 */
public class ArraysCoins {
    /**
     * <pre>
     * 问题描述
     * 　　题目描述：现有硬币六种，分别为 {1元、5元、10元、20元、50元、100元}，
     * 假设每种硬币数量均无限多，问用它们来凑够N元有多少种组合方式。
     * 例如n=200，那么一种可能的组合方式为 200 = 10 * 10 + 2＊50.
     *
     * 类似的题目还有：
     * [华为面试题] 1分2分5分的硬币三种，组合成1角，共有多少种组合
     * [创新工厂笔试题] 有1分，2分，5分，10分四种硬币，每种硬币数量无限，给定n分钱，有多少中组合可以组成n分钱。
     *
     * 这个题用动态规划很好做。
     * </pre>
     *
     * <pre>
     * 解题思路：
     *      给定一个数值sum，假设我们有m种不同类型的硬币{V1, V2, ..., Vm}，
     *      如果要组合成sum，那么我们有sum = x1 * V1 + x2 * V2 + ... + xm * Vm .
     *      求所有可能的组合数，就是求满足前面等值的系数{x1, x2, ..., xm}的所有可能个数。
     *
     *   从上面的分析中我们可以这么考虑，我们希望用m种硬币构成sum，根据最后一个硬币Vm的系数的取值无非有这么几种情况,
     *   xm分别取｛0, 1, 2, ..., sum/Vm}。即 上面分析中的等式和下面的几个等式的联合是等价的：
     *
     *   <code>
     *       sum = x1 * V1 + x2 * V2 + ... + 0 * Vm
     *       sum = x1 * V1 + x2 * V2 + ... + 1 * Vm
     *       sum = x1 * V1 + x2 * V2 + ... + 2 * Vm
     *       ...
     *       sum = x1 * V1 + x2 * V2 + ... + K * Vm
     *   </code>
     *   其中K是该xm能取的最大数值K = sum / Vm。
     *
     *   进行如下变量的定义： dp[i][sum] = 用前i种硬币构成sum 的所有组合数.
     *   那么题目的问题实际上就是求 dp[m][sum]，即用前m种硬币（所有硬币）构成sum的所有组合数。
     *
     *   举例
     *   <code>
     *       当xn = 0时，有多少种组合？
     *       实际上就是前i-1种硬币组合sum，有dp[i-1][sum]种！
     *
     *       xn = 1 时呢，有多少种组合？
     *       实际上是用前i-1种硬币组合成(sum - Vm)的组合数，有dp[i-1][sum -Vm]种;
     *
     *
     *   </code>
     *
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("输入:");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int coin[] = { 1, 5, 10, 20, 50, 100 };

            // dp[i][j]表示用前i种硬币凑成j元的组合数
            long[][] dp = new long[7][n + 1];

            for (int i = 1; i <= n; i++) {
                dp[0][i] = 0; // 用0种硬币凑成i元的组合数为0
            }
            for (int i = 0; i <= 6; i++) {
                dp[i][0] = 1; // 用i种硬币凑成0元的组合数为1,所有硬币均为0个即可
            }

            for (int i = 1; i <= 6; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = 0;
                    for (int k = 0; k <= j / coin[i - 1]; k++) {
                        dp[i][j] += dp[i - 1][j - k * coin[i - 1]];
                    }
                }
            }

            System.out.println(dp[6][n] + "种");
        }
        sc.close();
    }

}
