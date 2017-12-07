package com.qushihan.IO流;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class FileInputStreamDemo1 {

    private static final int SIZE = 1024;

    /*
     * 将已有文件的数据读取出来
     * 既然是读，使用InputStream
     * 而且是要操作文件。FileInputStream
     *
     */
    @Test
    public void readfile() {
        String file_path = "D:/test/shuju.txt";
        //为了确保文件一定在之前是存在的，将字符串路径封装成File对象
        File file = new File(file_path);
        if (!file.exists()) {
            throw new RuntimeException("要读取的文件不存在");
        }
        //创建文件字节读取流对象时，必须明确与之关联的数据源。
        try (InputStream fis = new FileInputStream(file)) {
            //调用读取流对象的读取方法
            //1.read()返回的是读取到的字节
            //2.read(byte[] b)返回的是读取到的字节个数
            //创建一个字节数组，定义len记录长度
            int len = 0;
            byte[] buffer = new byte[SIZE];
            while ((len = fis.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, len));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}