package com.yueny.fw.practice.weakreference;

import org.junit.Test;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {
    @Test
    public void test() {
        DemoA a = new DemoA();
        DemoB b = new DemoB(a);

        a = null;
//        b = null;

        b.doSomething();
        System.out.println("end");
    }

    @Test
    public void test2() {
        DemoA a = new DemoA();
        WeakReference b = new WeakReference(a);


        a = null;

        System.out.println("end");
    }
}
