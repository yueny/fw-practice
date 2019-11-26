package com.yueny.fw.practice.design.single;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册式单例
 *
 * meishiyong
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-11-26 11:24
 */
public class RegisterMap {
    private RegisterMap(){}

    private static Map<String, Object> register = new HashMap<>();

    public static final RegisterMap getInstance(String name){
        if(name == null){
            name = RegisterMap.class.getName();
        }

        if(register.get(name) == null){
            try{
                register.put(name, new RegisterMap());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return (RegisterMap) register.get(name);
    }
}
