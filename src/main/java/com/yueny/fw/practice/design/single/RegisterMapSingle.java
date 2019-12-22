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
public class RegisterMapSingle implements ISingle {
    private RegisterMapSingle(){}

    private static Map<String, Object> register = new HashMap<>();

    public static final RegisterMapSingle getInstance(String name){
        if(name == null){
            name = RegisterMapSingle.class.getName();
        }

        if(register.get(name) == null){
            try{
                register.put(name, new RegisterMapSingle());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return (RegisterMapSingle) register.get(name);
    }
}
