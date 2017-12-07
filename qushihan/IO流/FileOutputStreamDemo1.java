package com.qushihan.IO流;

import org.junit.Test;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class FileOutputStreamDemo1 {

    @Test
    //使用字节数组把数据写出。
    public void writeTest1() {
        //找到目标文件
        File file = new File("D:/test/FileOutputTest1.txt");
        //建立数据输出通道
        try (OutputStream fos = new FileOutputStream(file)) {
            //把数据写出。
            String data = "你好哈尔滨";
            byte[] buffer = data.getBytes("utf-8");
            fos.write(buffer, 0, buffer.length); // 0 从字节数组的指定索引值开始写， 2：写出两个字节。
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    //使用字节数组把数据写出。
    public void writeTest2() {
        //找到目标文件
        File file = new File("D:/test/FileOutputTest2.txt");
        //建立数据输出通道
        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            //把数据写出。
            String data = "\r\nhello world";
            fos.write(data.getBytes("utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    //每次只能写一个字节的数据出去。
    public void writeTest3() {
        //找到目标文件
        File file = new File("D:/test/FileOutputTest3.txt");
        //建立数据的输出通道
        try (OutputStream fos = new FileOutputStream(file)) {
            //把数据写出
            fos.write('h');
            fos.write('e');
            fos.write('l');
            fos.write('l');
            fos.write('o');
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
