package com.yueny.fw.practice.files.write;

import com.yueny.fw.practice.files.Salary;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * JAVA的NIO中的FileChannel进行写入
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-04 17:00
 */
@Component
public class NIOFileAppender {
    /**
     * NIO进行写入
     * @throws IOException
     */
    public void write(String filePathName, Long count) throws IOException {
        Long startTime = System.currentTimeMillis();

        FileOutputStream fos = new FileOutputStream(filePathName, true);
        FileChannel channel = fos.getChannel();

        // 追加的数据
        StringBuffer content = new StringBuffer();

        // 追加头
        StringBuffer sb = new StringBuffer("工号");
        sb.append("|");
        sb.append("姓名");
        sb.append("|");
        sb.append("基础月薪资");
        sb.append("|");
        sb.append("年终奖");
        content.append(sb.toString()).append("\r\n");

        // 此处一直追加。存在内存溢出风险
        long i = count;
        while(i > 0) {
            Salary salary = new Salary(count-i+1).build();
            content.append(salary.toString()).append("\r\n");
            i --;

            if(i % 10000 ==0){
                System.out.println("文件内容追加中:" + i);
            }
        }

        ByteBuffer buf = ByteBuffer.wrap(content.toString().getBytes());
        buf.put(content.toString().getBytes());
        buf.flip();
        channel.write(buf);

        channel.close();
        fos.close();

        System.out.println("文件" + filePathName + "创建完成，耗时:" + (System.currentTimeMillis()-startTime)/1000 + " 秒。");
    }

}
