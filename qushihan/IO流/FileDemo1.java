package com.qushihan.IO流;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileDemo1 {



    @Test
    //文件操作
    public void file(){
        String file_path="D:"+System.getProperty("file.separator")+"test/doFile1.txt";
        File file=new File(file_path);

        //创建文件 没啥用
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //判断是否是目录
        System.out.println(file.isDirectory());
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.length());
    }

    @Test
    //浏览目录下的文件
    public void file1(){
        String dir="D://";
        File file=new File(dir);
        String[] filesname=file.list();
        File[] files = file.listFiles();
//        for(String name:filesname){
//            System.out.println(name);
//        }
        for(File s:files){
            System.out.println(s+"--"+s.length());
        }
    }

    @Test
    //过滤文件
    public void file2(){
        String dir="D://test";
        File file=new File(dir);
        File[] files=file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("txt")||name.endsWith("wmv");
            }
        });
        for(File s:files){
            System.out.println(s.getName());
        }
    }
}
