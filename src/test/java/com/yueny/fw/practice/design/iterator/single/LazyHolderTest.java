package com.yueny.fw.practice.design.iterator.single;

import java.lang.reflect.Constructor;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-11-25 10:36
 */
public class LazyHolderTest {
    public static void main(String[] args) {
        try{
            // 第一次。 因为没有被初始化过，所以允许初始化了
            Object object = LazyHolder.getInstance();
            System.out.println(object); // sout

            Class<?> clazz = LazyHolder.class;

            // 通过反射拿到私有的构造方法
            Constructor c = clazz.getDeclaredConstructor(null);

            // 强制访问， 第二次，不再允许初始化了
            c.setAccessible(true);
            Object object1 = c.newInstance();
            System.out.println(object1);

            Object object2 = c.newInstance();
            System.out.println(object2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
