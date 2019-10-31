package com.yueny.fw.practice.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-30 17:34
 */
public class ThreadPoolMain {
    public static void main(String[] args) {
        /**
         * int corePoolSize,
         *                               int maximumPoolSize,
         *                               long keepAliveTime,
         *                               TimeUnit unit,
         *                               BlockingQueue<Runnable> workQueue,
         *                               ThreadFactory threadFactory,
         *                               RejectedExecutionHandler handler
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,5,
                0L, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(300),
                new ThreadFactoryBuilder().setNameFormat("demo").build(),
                new ThreadPoolExecutor.AbortPolicy()
                );


    }

}
