package com.qushihan.IO流;

import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;


public class FileWriterDemo1 {
    @Test
    public void write() {
        File file = new File("D://test/FileWriter.txt");
        try (Writer wr = new FileWriter(file)) {
            wr.write("你是真的皮");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
