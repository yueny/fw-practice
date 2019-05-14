package com.yueny.fw.practice.gc;

/**
 * <code>
 *
 * </code>
 *
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/5/14 下午1:18
 */
public class GCMain {
    public static void main(String [] args){
        {
            byte[] placeholder = new byte[64*1024*1024];
        }

        int a= 0;

        // placeholder
        System.gc();
    }

}
