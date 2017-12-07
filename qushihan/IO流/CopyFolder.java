package com.qushihan.IO流;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFolder {
    private static String source_path = "D:\\迅雷影音";
    private static String target_path = "D:\\test\\迅雷影音";

    @Test
    public void copy() {

        new File(target_path).mkdir();
        copy(source_path, target_path);
    }

    public void copy(String source_path, String target_path) {
        File source = new File(source_path);
        File[] files = source.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    new File(target_path + System.getProperty("file.separator") + file.getName()).mkdir();
                    copy(file.getPath(), target_path + System.getProperty("file.separator") + file.getName());
                } else {
                    try (FileInputStream fis = new FileInputStream(file.getPath());
                         FileOutputStream fos = new FileOutputStream(target_path + System.getProperty("file.separator") + file.getName())) {
                        int len = 0;
                        byte[] buffer = new byte[1024];
                        while ((len = fis.read(buffer)) != -1) {
                            fos.write(buffer, 0, len);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
