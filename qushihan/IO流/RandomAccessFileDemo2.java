package com.qushihan.IO流;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo2 {
    @Test
    public void merge() {
        File file = new File("D://test/a2.mp3");
        try (RandomAccessFile r = new RandomAccessFile("D://test/a1.mp3", "r");
             RandomAccessFile w = new RandomAccessFile(file, "rw")) {
            w.seek(file.length()); //定位到a2文件的末尾
            int len = 0;
            byte[] buffer = new byte[1024 * 1024];
            while ((len = r.read(buffer)) != -1) {
                w.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
