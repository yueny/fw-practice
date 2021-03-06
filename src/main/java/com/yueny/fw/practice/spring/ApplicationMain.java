package com.yueny.fw.practice.spring;

import com.yueny.fw.practice.lock.Deadlock;
import com.yueny.fw.manager.IService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-21 14:10
 */
public class ApplicationMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext( "classpath:/config/spring-bean.xml");
        System.out.println("context 启动成功" + context.toString());

//        // 获取FactoryBean的实现类，就要getBean(&BeanName)，在BeanName之前加上&。
//        FactoryBean service = (FactoryBean)context.getBean("&designFactoryBean");
        // 不加 &， 则获取的是FactoryBean实现类中的getObject()方法返回的代理类
        IService service = (IService) context.getBean("designFactoryBean");
        service.doit("userName");

//        IOC 代理类
//        ProxyFactoryBean
//        CopyOnWriteArrayList
//        AbstractQueuedSynchronizer
        Deadlock deadlock = context.getBean("deadlock", Deadlock.class);
//        System.out.println(deadlock.toString());
    }

}
