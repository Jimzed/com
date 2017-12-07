package com.qushihan.IO流;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

public class FileStreamCopy {
    private static String src="C://test/a.wmv";
    private static String out="D://test/acopy.wmv";
    @Test
    public void copy(){
        try(InputStream fis=new FileInputStream(src);OutputStream fos=new FileOutputStream(out)){
            int len=0;
            byte[] buffer=new byte[1024*1024];

            long start = System.currentTimeMillis();
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,buffer.length);
            }
            long end=System.currentTimeMillis();
            SimpleDateFormat sdf=new SimpleDateFormat("s");
            System.out.println(sdf.format(end-start));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
