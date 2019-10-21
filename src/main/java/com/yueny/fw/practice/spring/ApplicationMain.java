package com.yueny.fw.practice.spring;

import com.yueny.fw.practice.lock.Deadlock;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-21 14:10
 */
public class ApplicationMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext( "classpath:/config/spring-bean.xml");
        System.out.println(context.toString());

//        Deadlock deadlock = context.getBean("deadlock", Deadlock.class);
//        System.out.println(deadlock.toString());
    }

}
