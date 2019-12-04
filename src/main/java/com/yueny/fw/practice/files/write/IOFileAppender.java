package com.yueny.fw.practice.files.write;

import com.yueny.fw.practice.files.Salary;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Java的IO中BufferedWriter写入文件
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-04 11:37
 */
@Component
public class IOFileAppender {
    /**
     * 写入文件
     * @return
     * @throws IOException
     */
    public File write(String filePathName, Long count) throws IOException {
        Long startTime = System.currentTimeMillis();

        File file = new File(filePathName);
        FileOutputStream fos = new FileOutputStream(file);

        //创建高效缓冲区流的对象
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

        // 追加头
        StringBuffer sb = new StringBuffer("工号");
        sb.append("|");
        sb.append("姓名");
        sb.append("|");
        sb.append("基础月薪资");
        sb.append("|");
        sb.append("年终奖");

        //输出数据
        writer.write(sb.toString() + "\r\n");

        long i = count;
        while(i > 0) {
            Salary salary = new Salary(count-i+1).build();
            writer.write(salary.toString() + "\r\n");
            i --;

            if(i % 10000 ==0){
                System.out.println("文件内容追加中:" + i);
            }
        }

        //清空缓冲区
        writer.flush();
        //关闭高效缓冲区的流就会自动关闭FileWriter
        writer.close();
        fos.close();

        System.out.println("文件" + filePathName + "创建完成，耗时:" + (System.currentTimeMillis()-startTime)/1000 + " 秒。");

        return file;
    }
}
