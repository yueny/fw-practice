package com.yueny.fw.practice.thread;

import com.yueny.fw.console.service.AbstractService;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/7/12 下午1:45
 */
public class ThreadIdMain extends AbstractService {
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadLocalId =
            new ThreadLocal<Integer>() {
                @Override protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    public static int get() {
        return threadLocalId.get();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
             System.out.println(Thread.currentThread().getId() + "/" + get());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getId() + "/" + threadLocalId.get());
                }
            }).start();
        }
    }

}
