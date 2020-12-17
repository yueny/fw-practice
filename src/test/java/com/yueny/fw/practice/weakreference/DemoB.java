package com.yueny.fw.practice.weakreference;

public class DemoB {
    private DemoA demoA;

    DemoB(DemoA demoA){
        this.demoA = demoA;
    }

    public void doSomething(){
        System.out.println("DemoB");

        demoA.doSomething();
    }
}
