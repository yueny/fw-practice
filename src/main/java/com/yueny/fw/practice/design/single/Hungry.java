package com.yueny.fw.practice.design.single;

/**
 * 单例模式：
 * 初衷：
 * 为了使资源可以共享，只需要赋值或者初始化一次，即可重复利用。
 * 应用场景：
 * Listener本身单例，日历Calender, IOC容器，配置Config信息
 */

/**
 * 单例模式： 饿汉式
 *
 * 它是在类加载的时候就立即初始化， 并且创建单例对象。
 *
 * 优点：
 * 没有加任何锁，执行效率较高。
 * 在用户体验上，比懒汉式更好。
 * 绝对线程安全的。
 *
 * 缺点：
 * 类加载的时候就初始化，始终占用空间。如果不使用，就是在浪费内存了。
 *
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-11-25 10:10
 */
public class Hungry {
    private Hungry(){

    }

    private static final Hungry hungry = new Hungry();

    public static Hungry getInstance(){
        return hungry;
    }
}
