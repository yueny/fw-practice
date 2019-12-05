package com.yueny.fw.practice.files.read;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.yueny.fw.practice.files.FileMd5Util;
import com.yueny.fw.practice.files.Salary;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * 按缓冲区大小分批读取
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-04 17:29
 */
@Component
public class IOReader {
    /**
     * Java IO读取文件的方式， 1亿条数据耗时31秒
     * @return
     * @throws Exception
     */
    public Long read(String filePathName) throws Exception {
        Long startTime = System.currentTimeMillis();
        File file = new File(filePathName);

        InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // 建立一个输入流对象reader

        //创建高效缓冲区流的对象
        // 如果不指定buffer大小(缓冲区)，则readLine()使用的buffer有8192个字符(8192 = 2 to the power of 13)。在达到buffer大小之前，只有遇到"/r"、"/n"、"/r/n"才会返回。
        // private static int defaultCharBufferSize = 8192;
        // 较小缓冲区的一个原因是当在有限内存设备上运行时，缓冲区会消耗内存。
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言

        String line = ""; // 每一行的内容
        // 条数
        LongAdder count = new LongAdder();
        int i = 0;
        // BufferedReader的readLine()方法是阻塞式的, 如果到达流末尾, 就返回null. readLine() 是一次性从缓冲区中将内容全部读取进来。
        while ((line = br.readLine()) != null) {
            List<String> split = Lists.newArrayList(Splitter.on("|").trimResults().split(line));

            // 忽略首行
            if(i == 0){
                i++;
                continue;
            }

            try{
                new Salary(Long.valueOf(split.get(0)), split.get(1), Integer.valueOf(split.get(2)), Integer.valueOf(split.get(3)));

                count.increment();
                i++;
            }catch (Exception ex){
                ex.printStackTrace();
                System.out.println("出错数据：" + line + "["+Arrays.asList(split)+"]");
            }

            if(i % 10000 ==0){
                System.out.println("文件内容读取中:" + i);
            }

        }
        reader.close();

        //关闭高效缓冲区的流就会自动关闭FileWriter
        br.close();

        System.out.println("文件" + filePathName + "读取，耗时:" + (System.currentTimeMillis()-startTime)/1000 + " 秒。");
        return count.sum();
    }

    /**
     *
     */
    public String md5(String filePathName){
        long begin = System.currentTimeMillis();

        File big = new File(filePathName);

        String md5 = "";
        try{
            md5 = FileMd5Util.getFileMD5String(big);
        }catch (Exception e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        // 2GB 文件的计算大概在 18 s
        System.out.println("md5:"+md5+" time:"+((end-begin)/1000)+"s");

        return md5;
    }
}
