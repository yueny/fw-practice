package com.yueny.fw.practice.threadlocal;

public class InheritableThreadLocalsTest {
    private static ThreadLocal<Object> localObject = new InheritableThreadLocal<>();

    /**
     * 父子线程控制
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final int key = i;
            localObject.set("B______" + key);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.err.println(Thread.currentThread().getName() + "\t" + localObject.get().toString());
                }
            });
            t.start();
            System.err.println(Thread.currentThread().getName() + "\t" + localObject.get());
        }
        System.err.println(Thread.currentThread().getName() + "\t" + localObject.get());
    }

}
