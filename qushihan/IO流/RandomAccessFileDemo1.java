package com.qushihan.IO流;

import org.junit.Test;

import java.io.RandomAccessFile;

public class RandomAccessFileDemo1 {
    @Test
    public void copy() {
        try (RandomAccessFile r = new RandomAccessFile("C://test/a.wmv", "r");
             RandomAccessFile w = new RandomAccessFile("D://test/acopy2.wmv", "rw")) {
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
