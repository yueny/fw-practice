package com.yueny.fw.practice.files;

import com.yueny.fw.practice.files.read.IOReader;
import com.yueny.fw.practice.files.read.NIOReader;
import com.yueny.fw.practice.files.write.IOFileAppender;
import com.yueny.fw.practice.files.write.NIOFileAppender;

import java.io.File;

/**
 * @Author yueny09 <deep_blue_yang@126.com>
 * @Date 2019-12-04 17:03
 */
public class BigFileGen {
    private static NIOFileAppender nioFileAppender = new NIOFileAppender();
    private static IOFileAppender ioFileAppender = new IOFileAppender();

    private static NIOReader nioReader = new NIOReader();
    private static IOReader ioReader = new IOReader();


    public static void main(String[] args) {
        Long count = 100000000L;
        String filePathName = "a.txt";

        try {
//            write(filePathName, count);

            reader(filePathName);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void write(String filePathName, Long count) throws Exception {
        File file = ioFileAppender.write(filePathName, count);
//            nioFileAppender.write(filePathName, count);
    }

    private static Long reader(String filePathName) throws Exception {
//        Long count = ioReader.read(filePathName);
        Long count = nioReader.read(filePathName);
        System.out.println("总数量：" + count);

        return count;
    }

}
