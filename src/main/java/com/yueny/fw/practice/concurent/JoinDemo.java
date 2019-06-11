package com.yueny.fw.practice.concurent;

/**
 * <code>
 * 创建了10个线程，每个线程都会等待前一个线程结束才会继续运行。
 * 可以通俗的理解成接力，前一个线程将接力棒传给下一个线程，然后又传给下一个线程......
 * </code>
 *
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/6/11 下午8:16
 */
public class JoinDemo {
    public static void main(String[] args) {
        Thread previousThread = Thread.currentThread();

        for (int i = 1; i <= 10; i++) {
            Thread curThread = new JoinThread(previousThread, i);
            curThread.start();

            previousThread = curThread;
        }
    }

    static class JoinThread extends Thread {
        private Thread previousThread;
        private final int i;

        public JoinThread(Thread thread, int i) {
            this.previousThread = thread;
            this.i = i;
        }

        @Override
        public void run() {
            try {
                // 当前线程 会等待 previousThread 线程终止后当前线程才会继续执行。
                previousThread.join();
                System.out.println(previousThread.getName() + " terminated." + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
