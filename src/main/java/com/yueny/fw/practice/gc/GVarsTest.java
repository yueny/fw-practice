package com.yueny.fw.practice.gc;

/**
 * 编译文件
 * 在 class 目录执行 javap -verbose GVarsTest
 *
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/6/6 下午6:19
 */
public class GVarsTest {
    public void foo(int a,int b){
        {
            int d = 0;
        }
        int c = 0;
        return;
    }

}
