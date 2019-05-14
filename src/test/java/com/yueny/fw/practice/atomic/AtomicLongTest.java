package com.yueny.fw.practice.atomic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class AtomicLongTest {
    @Test
    public void test(){
        final long startTime = System.currentTimeMillis();
        final int taskCount = 3;
        final long targetCount = 10000;

        AtomicLong longVal = new AtomicLong(0);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Callable<Long> callable = new Callable<Long>() {
            @Override
            public Long call() {
                Long v = longVal.incrementAndGet();
                while (v < targetCount) {
                    v = longVal.incrementAndGet();
                }

                long endTime = System.currentTimeMillis();
                log.info("耗时:{} ms, 最终值:{}.", endTime-startTime, v);

                return v;
            }
        };

        for (int i=0; i<taskCount; i++){
            try{
                Future<Long> f= executorService.submit(callable);

                log.info("最终值:{}.", f.get());
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

}
