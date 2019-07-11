package com.yueny.fw.practice.finallya;

import com.yueny.fw.practice.AbstractService;

/**
 * try...cathch...finally中的 finally 的操作
 *
 * 此种情景下， log日志不会被输出， 这是一个唯一的特例。其他情况均可以被输出。
 *
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/7/11 下午5:34
 */

public class FinallyMain extends AbstractService {
    public static void main(String[] args) {
        try{
            logger.info("开始执行任务");
            System.exit(-1);
        }finally{
            logger.info("我任务完成了");
        }
    }
}
