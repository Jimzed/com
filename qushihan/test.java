package com.qushihan;

import java.io.*;

public class test {
    public void read(){
        String path="D:/test/english.txt";
        try (InputStream fis=new FileInputStream(path)){
            int length=0;
            byte[] buffer=new byte[1024];// 1kb
            while((length=fis.read(buffer))!=-1){
//                System.out.print(new String(buffer,0,length));
                System.out.write(buffer,0,length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write(){
        try(OutputStream os=new FileOutputStream("D:/test/123.txt")){
            os.write("你好哈尔滨".getBytes("utf-8"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new test().read();
    }
}
