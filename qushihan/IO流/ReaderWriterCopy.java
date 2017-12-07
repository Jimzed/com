package com.qushihan.IO流;

import org.junit.Test;

import java.io.*;

public class ReaderWriterCopy {
    @Test
    public void copy() {
        File file1 = new File("D://test/ReaderWriterCopy1.txt");
        File file2 = new File("D://test/ReaderWriterCopy2.txt");
        try (Reader fr = new FileReader(file1); Writer fw = new FileWriter(file2)) {
            int len = 0;
            char[] buffer = new char[1024];
            while ((len = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
