package com.yueny.fw.practice.gc;

/**
 * <code>
 *  启动参数增加 -verbose:gc
 * </code>
 *
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/5/14 下午1:18
 */
public class GCMain {
    public static void main(String [] args){
        {
            byte[] placeholder = new byte[64*1024*1024];
            placeholder = null;
        }

        byte[]arr= new byte[20*1024*1024];

        // placeholder
        System.gc();
    }

}
