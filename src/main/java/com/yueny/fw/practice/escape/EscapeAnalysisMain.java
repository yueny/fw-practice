package com.yueny.fw.practice.escape;

/**
 * 逃逸分析
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-16 13:05
 */
public class EscapeAnalysisMain {
    /**
     * 使用for循环，在代码中创建100万个User对象。
     *
     * 我们在alloc方法中定义了User对象，但是并没有在方法外部引用他。
     * 也就是说，这个对象并不会逃逸到alloc外部。经过JIT的逃逸分析之后，就可以对其内存分配进行优化。
     *
     * 指定以下JVM参数并运行：
     * -Xmx1G -Xms1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
     *
     * 在程序打印出 cost XX ms 后，代码运行结束之前，我们使用[jmap][1]命令，来查看下当前堆内存中有多少个User对象：
     * $ jps
     * $ jmap -histo <pid>
     *
     * @param args
     */
    public static void main(String[] args) {
        long a1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            alloc();
        }
        // 查看执行时间
        long a2 = System.currentTimeMillis();
        System.out.println("cost " + (a2 - a1) + " ms");

        // 为了方便查看堆内存中对象个数，线程sleep
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    private static void alloc() {
        User user = new User();
    }

    static class User {

    }

}
