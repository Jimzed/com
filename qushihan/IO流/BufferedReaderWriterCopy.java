package com.qushihan.IO流;

import org.junit.Test;

import java.io.*;

public class BufferedReaderWriterCopy {
    @Test
    public void copy() {
        File src = new File("C://test/BufferedReaderWriterCopy.txt");
        File out = new File("D://test/BufferedReaderWriterCopy.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(src), 1024 * 1024);
             BufferedWriter bw = new BufferedWriter(new FileWriter(out), 1024 * 1024)) {
            int len = 0;
            char[] buffer = new char[1024 * 1024];
            while ((len = br.read(buffer)) != -1) {
                bw.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
