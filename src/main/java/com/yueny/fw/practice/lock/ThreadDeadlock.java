package com.yueny.fw.practice.lock;

/**
 * <pre>
 * 死锁问题是多线程特有的问题，它可以被认为是线程间切换消耗系统性能的一种极端情况。
 * 在死锁时，线程间相互等待资源，而又不释放自身的资源，导致无穷无尽的等待，其结果是系统任务永远无法执行完成。
 * 死锁问题是在多线程开发中应该坚决避免和杜绝的问题。
 *
 * 一般来说，要出现死锁问题需要满足以下条件：
 * 1. 互斥条件：一个资源每次只能被一个线程使用。
 * 2. 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
 * 3. 不剥夺条件：进程已获得的资源，在未使用完之前，不能强行剥夺。
 * 4. 循环等待条件：若干进程之间形成一种头尾相接的循环等待资源关系。
 *
 * 只要破坏死锁 4 个必要条件之一中的任何一个，死锁问题就能被解决。
 * </pre>
 *
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/6/5 下午3:46
 */
public class ThreadDeadlock {
    public static void main(String[] args) throws InterruptedException {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();

        Thread t1 = new Thread(new SyncThread(obj1, obj2), "t1");
        Thread t2 = new Thread(new SyncThread(obj2, obj3), "t2");
        Thread t3 = new Thread(new SyncThread(obj3, obj1), "t3");

        t1.start();
        Thread.sleep(5000);
        t2.start();
        Thread.sleep(5000);
        t3.start();
    }

}

class SyncThread implements Runnable{
    private Object obj1;
    private Object obj2;

    public SyncThread(Object o1, Object o2){
        this.obj1=o1;
        this.obj2=o2;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " acquiring lock on "+obj1);
        synchronized (obj1) {
            System.out.println(name + " acquired lock on "+obj1);
            work();
            System.out.println(name + " acquiring lock on "+obj2);
            synchronized (obj2) {
                System.out.println(name + " acquired lock on "+obj2);
                work();
            }
            System.out.println(name + " released lock on "+obj2);
        }
        System.out.println(name + " released lock on "+obj1);
        System.out.println(name + " finished execution.");
    }
    private void work() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
