package com.yueny.fw.practice.suanfa;

import java.util.*;

/**
 * 洗牌算法
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-11-20 10:48
 */
public class Shuffle {
    public static void main(String[] args) {
        Test_XiPai();
    }

    /**
     * 扑克牌随机洗牌
     */
    private static void Test_XiPai() {
        String[] pai = {"红心A","红心1","红心2","红心3","红心4","红心5","红心6","红心7","红心8","红心9","红心10","红心K","红心Q","红心J",
                "黑桃A","黑桃1","黑桃2","黑桃3","黑桃4","黑桃5","黑桃6","黑桃7","黑桃8","黑桃9","黑桃10","黑桃K","黑桃Q","黑桃J",
                "方块A","方块1","方块2","方块3","方块4","方块5","方块6","方块7","方块8","方块9","方块10","方块K","方块Q","方块J",
                "梅花A","梅花1","梅花2","梅花3","梅花4","梅花5","梅花6","梅花7","梅花8","梅花9","梅花10","梅花K","梅花Q","梅花J","大王","小王"};
        //List集合
        List<String> li = new ArrayList<>();

        for (int i = 0; i < pai.length; i++) {
            li.add(pai[i]);
        }

        //遍历List
        Iterator<String> it = li.iterator();
        while (it.hasNext()) {
            String spai = it.next();
            System.out.print("<" + spai +">");
        }

        System.out.println("\n");

        //开始准备洗牌
        Random r = new Random();
        //打印随机数
        System.out.println(r.nextInt());

        //洗牌 随机乱序
        Collections.shuffle(li,r);

        //遍历集合list
        for (int i = 0; i < li.size(); i++) {
            String rand_pai = li.get(i);
            System.out.print("<" + rand_pai +">");

        }
    }


}
