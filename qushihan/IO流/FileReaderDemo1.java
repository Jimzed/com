package com.qushihan.IO流;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo1 {
    @Test
    public void read() {
        File file = new File("D://test/FileReader.txt");
        try (Reader fr = new FileReader(file)) {
            int len = 0;
            char[] buffer = new char[1024];
            while ((len = fr.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
