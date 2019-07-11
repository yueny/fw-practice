package com.yueny.fw.practice.concurent;

/**
 * <code>
 *
 * </code>
 *
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/6/11 下午8:45
 */
public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
            method();
        }
    }

    private static void method() {
    }
}