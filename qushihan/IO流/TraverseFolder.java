package com.qushihan.IO流;

import java.io.File;

public class TraverseFolder {
    public static void traverse(String path) {
        File currentfile = new File(path);
        if (currentfile.exists()) {
            File[] files = currentfile.listFiles();
            if (files.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.println("文件夹:" + file.getAbsolutePath());
                        traverse(file.getAbsolutePath());
                    } else {
                        System.out.println("文件:" + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }

    public static void main(String[] args) {
        String file_path = "D://";
        traverse(file_path);
    }
}
