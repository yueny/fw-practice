package com.yueny.fw.practice.design.iterator.single;

import java.io.Serializable;

/**
 * 反序列化时导致单例被破坏： 枚举只会初始化一次
 *
 *
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-11-25 10:44
 */
public class Seriable implements Serializable {
    // 序列化： 把内存中的抓捕反光条，通过转换成字节码的形式，从而转换为一个IO流， 写入到磁盘/网络Io中。
    // 从而将内存的状态给永久保持

    // 反序列化：
    // 将已经持久化的字节码内容转换为IO流， 通过IO流的读取内容转换为Java对象, 进而重新创建对象new。

    public static final Seriable INSTANCE = new Seriable();

    private Seriable(){

    }

    public static Seriable getInstance(){
        return INSTANCE;
    }

    // 作用：反序列时返回指定实例
    private Object readResolve(){
        return INSTANCE;
    }

}
