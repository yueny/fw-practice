package com.yueny.fw.practice.design.iterator.single;

/**
 * 单例模式： 懒汉式， 内部类模式
 *
 * 特点：
 * 无锁。
 * 默认不实例化。在外部需要使用的时候才进行实例化， 延时加载。
 * 内部类一定是方法初始化之前初始化，如果没有使用的话，内部类是不加载的。
 *
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-11-25 10:20
 */
public class LazyHolder {
    // 该值可能会被反射改变值。 TODO
    private static  boolean initialized = false;

    private LazyHolder(){
        // 防止反射入侵。构造方法只会被实例化一次
        synchronized (LazyHolder.class){
            if(initialized == false){
                initialized = !initialized;
            }else{
                throw new RuntimeException("实例化多次");
            }
        }
    }

    // static 为了使单例的空间共享
    // final 不允许被重写
    public static final LazyHolder getInstance(){
        //  再返回结果以前，一定会先加载内部类，然后再返回
        return LazyHolderIn.LAZY;
    }

    // 默认不加载
    // static 只会被初始化一次
    private static class LazyHolderIn{
        // 静态块，公共内存区域
        private static final LazyHolder LAZY = new LazyHolder();
    }
}
