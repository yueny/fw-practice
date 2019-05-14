package com.yueny.fw.practice.atomic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterPoolExecutor  extends ThreadPoolExecutor {
    //统计次数
    public AtomicInteger count=new AtomicInteger(0);
    public long startTime=0;
    public String funcname="";
    public int TASK_COUNT_VAL = 5000;
    public CounterPoolExecutor(int corePoolSize, int maximumPoolSize,
                               long keepAliveTime, TimeUnit unit,
                               BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void afterExecute(Runnable r,Throwable t){
        // 统计执行次数
        int l=count.addAndGet(1);

        // 如果任务已经完成了
        if(l==TASK_COUNT_VAL){
            System.out.println(funcname+"spend time:"+(System.currentTimeMillis()-startTime));
        }
    }
}
