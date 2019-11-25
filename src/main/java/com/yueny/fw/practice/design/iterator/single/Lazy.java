package com.yueny.fw.practice.design.iterator.single;

/**
 * 单例模式： 懒汉式
 *
 * 特点：
 * 默认不实例化。在外部需要使用的时候才进行实例化， 延时加载。
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-11-25 10:20
 */
public class Lazy {
    private static Object object= new Object();

    private Lazy(){

    }

    // 静态块，公共内存区域
    private static Lazy lazy = null;

    public static Lazy getInstance(){
        // 返回实例之前， 先判断
        // 如果没有初始化，则进行初始化并进行赋值
        // 缓存存储
        if(lazy == null){
            synchronized (object){
                if(lazy == null){
                    lazy = new Lazy();
                }
            }
        }

        return lazy;
    }
}
