package com.yueny.fw.practice.files;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-04 16:57
 */
public class Salary {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int baseSalary;
    @Getter
    @Setter
    private int bonus;
    /**
     * 工号
     */
    @Getter
    private Long id;

    public Salary(Long id) {
        this.id = id;
    }

    public Salary(Long id, String name, int baseSalary, int bonus) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    // name 4位a-z随机,baseSalary 0-100随机,bonus 0-5随机 年薪总额 = baseSalary * 13 + bonus
    public Salary build() {
        this.name = getRandomName(4);
        // 0-100随机数
        this.baseSalary = (int)(100 * Math.random());
        // 0-5随机数
        this.bonus = (int)(5 * Math.random());

        return this;
    }

    /**
     * 生产Name随机函数 4位a-z随机
     * @param length
     * @return
     */
    private static String getRandomName(int length ){
        String base = "abcdefghijklmnopqrstuvwxyz";

        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for ( int i = 0; i < length; i++ ){
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return id + "|" + name + "|" + baseSalary + "|" + bonus;
    }
}
