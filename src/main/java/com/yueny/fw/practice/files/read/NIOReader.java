package com.yueny.fw.practice.files.read;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.yueny.fw.practice.files.Salary;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Stream;

/**
 * nio 内存一次性加载
 *
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-04 17:34
 */
@Component
public class NIOReader {
    /**
     * JDK8 NIO读取文件， 1亿条数据耗时34秒
     * @return
     * @throws Exception
     */
    public Long read(String filePathName) throws Exception {
        Long startTime = System.currentTimeMillis();
        // 条数
        LongAdder count = new LongAdder();

//        // 加了文件名的判断. 避免错误的解析DS_Store文件.
//        List<Path> fileList = Files.list(Paths.get(basePath))
//                .filter(path -> !Files.isDirectory(path) && !path.getFileName().toString().contains("DS_Store"))
//                .collect(Collectors.toList());

        // 从 path 文件中读取所有内容，并按行分割，返回一个 Stream<String>
        /**
         * If timely disposal of file system resources is required, the try-with-resources construct should be used to ensure that the stream’s close method is invoked after the stream operations are completed.
         *
         * 如果需要周期性的读取文件，需要使用 try-with-resources语句来保证stream的close方法被调用，从而关闭打开的文件。
         */
        try(Stream<String> lines = Files.lines(Paths.get(filePathName))) {
            lines
                    // 忽略首行
                    .skip(1)
                    .forEach((line) -> {
                        List<String> split = Lists.newArrayList(Splitter.on("|").trimResults().split(line));

                        // 此处无法忽略首行， 如果异常，则无视
                        try{
                            new Salary(Long.valueOf(split.get(0)), split.get(1), Integer.valueOf(split.get(2)), Integer.valueOf(split.get(3)));

                            count.increment();
                        }catch (Exception ex){
                            ex.printStackTrace();
                            System.out.println("出错数据：" + line);
                        }
                    });
        }

        System.out.println("文件" + filePathName + "读取，耗时:" + (System.currentTimeMillis()-startTime)/1000 + " 秒。");
        return count.sum();
    }
}
