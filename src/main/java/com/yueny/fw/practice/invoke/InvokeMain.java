package com.yueny.fw.practice.invoke;

import java.lang.reflect.Method;

/**
 * 反射使用和原理
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-18 09:20
 */
public class InvokeMain {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.yueny.fw.practice.invoke.InvokeMain");
            Object ref = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("mm");
            method.invoke(ref);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mm() {
    }
}
