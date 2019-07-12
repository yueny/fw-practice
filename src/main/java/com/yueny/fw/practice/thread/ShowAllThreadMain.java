package com.yueny.fw.practice.thread;

import com.yueny.fw.practice.AbstractService;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.TimeUnit;

/**
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/7/12 上午10:06
 */
public class ShowAllThreadMain extends AbstractService {

    public static void main(String[] args) {
        //虚拟机线程管理的接口Threads
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos =
                threadMXBean.dumpAllThreads(false, false);

        for(ThreadInfo threadInfo:threadInfos) {
            System.out.println("["+threadInfo.getThreadId()+"]"+" "
                    +threadInfo.getThreadName());
        }

    }
}
