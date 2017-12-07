package com.qushihan.IO流;

import org.junit.Test;

import java.io.*;

public class BufferedStreamCopy {
    @Test
    public void copy() {
        File src = new File("C://test/a.wmv");
        File out = new File("D://test/acopy1.wmv");
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src), 1024 * 1024);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(out), 1024 * 1024)) {
            int len = 0;
            byte[] buffer = new byte[1024 * 1024];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
