package com.yueny.fw.practice.factorybean;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 自己实现一个FactoryBean，功能：用来代理一个对象，对该对象的所有方法做一个拦截，在调用前后都输出一行LOG，模仿ProxyFactoryBean的功能。
 *
 * XML-Bean配置如下
 * <pre>
 *      <bean id="designFactoryBean" class="com.yueny.fw.practice.factorybean.DesignFactoryBean">
          <property name="interfaceName" value="com.yyy.xxx.HelloWorldService" />
          <property name="target" ref="helloWorldService" />
 *      </bean>
 * </pre>
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-22 14:29
 */
public class DesignFactoryBean implements FactoryBean<Object>, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(DesignFactoryBean.class);

    @Getter
    @Setter
    private String interfaceName;
    @Getter
    @Setter
    private Object target;

    private Object proxyObj;

    @Override
    public void afterPropertiesSet() throws Exception {
        proxyObj = Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{Class.forName(interfaceName)},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                        logger.debug("invoke method before......" + System.currentTimeMillis());

                        Object result = method.invoke(target, args);

                        logger.debug("invoke method after......" + System.currentTimeMillis());
                        return result;
                    }
                });


        logger.debug("invoke afterPropertiesSet......");
    }

    @Override
    public Object getObject() throws Exception {
        return proxyObj;
    }

    @Override
    public Class<?> getObjectType() {
        return proxyObj == null ? Object.class : proxyObj.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
