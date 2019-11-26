package com.yueny.fw.practice.design.single;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-11-26 11:25
 */
public class ThreadSafeTest {
    @Test
    public void test(){
        int countr = 100;

        CountDownLatch latch = new CountDownLatch(countr);

        final Set<Hungry> syncSet = Collections.synchronizedSet(new HashSet<>());

        for(int i=0; i<countr; i++){
            new Thread(){
                @Override
                public void run() {
                    super.run();

//                    syncSet.add(Hungry.getInstance());
                    Hungry hungry = Hungry.getInstance();
                    System.out.println(System.currentTimeMillis() + ":" + hungry);

                    latch.countDown();
                }
            }.start();
        }

        try {
            latch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
