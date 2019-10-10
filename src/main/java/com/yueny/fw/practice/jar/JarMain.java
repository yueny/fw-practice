package com.yueny.fw.practice.jar;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 读取jar文件信息
 *
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/5/14 下午1:18
 */
@Slf4j
public class JarMain {
    private static final String jarPath = "/Users/xiaobai/workspace/yueny/github/mblog/web-backend/target/mblog-latest.jar";

    public static void main(String[] args) {
        JarFile topLevelJarFile = null;
        try {
            topLevelJarFile = new JarFile(jarPath);

            // 拿到所有的各层级的文件、文件夹、对象、脚本
            Enumeration<JarEntry> entries = topLevelJarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();

                // 如果不是文件夹且以.jar结尾，则取得
                if (!entry.isDirectory() && entry.getName().endsWith(".jar")) {
                    // BOOT-INF/lib/
                    log.info("{}", entry.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
