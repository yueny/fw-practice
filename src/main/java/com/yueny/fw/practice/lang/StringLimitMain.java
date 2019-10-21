package com.yueny.fw.practice.lang;

/**
 * 模拟20万个汉字给某个字符串赋值
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-10-18 18:07
 */
public class StringLimitMain {
    public static String var = "";

    public static void main(String[] args) {
        String data = getData();
        System.out.println("data " + data.length());

        var = data;


//        System.out.println("var " + var);
    }

    private static String getData(){
//        String var1 = "我总共是十个汉字哦啊";
        String var1 = "aaaaaaaaaa";

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<20000000; i++) {
            sb.append(var1);
        }

        //此时已经是10*1万=20万字了。
        return sb.toString();
    }
}
