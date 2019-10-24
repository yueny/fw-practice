package com.yueny.fw.practice.factorybean;

import com.yueny.fw.practice.bo.CarBo;
import com.yueny.fw.practice.entry.CarType;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * 配置方式
 * <pre>
 *     <bean id="customer1" class="com.yueny.fw.practice.factorybean.DemoFactoryBean"
 *          p:val="10093,a,A"/>
 * </pre>
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-22 14:29
 */
public class DemoFactoryBean implements FactoryBean<CarBo> {
    @Getter
    @Setter
    private String val;

    @Override
    public CarBo getObject() throws Exception {
        CarBo customer = new CarBo();
        if(this.val != null) {
            String infos[] = this.val.split(",");
            if(infos.length==0) {
                return customer;
            }
            customer.setSeatCount(Integer.getInteger(infos[0]));
            if(infos.length >=3) {
                customer.setMake(infos[1]);
                customer.setType(CarType.valueOf(infos[2]));
            } else  if(infos.length >=2){
                customer.setMake(infos[1]);
            }
        }
        return customer;
    }

    @Override
    public Class<?> getObjectType() {
        return CarBo.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
