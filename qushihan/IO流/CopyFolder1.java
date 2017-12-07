package com.qushihan.IO流;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFolder1 {
    @Test
    public void testCopyAllDir(){
        String readPath="D:\\迅雷影音";
        String writePath="D:\\test\\迅雷影音";
        new File(writePath).mkdir();
        copyAllDir(readPath,writePath);
    }
    public void copyAllDir(String readPath,String writePath){
        File file=new File(readPath);
        File fs[]=file.listFiles();
        if(fs!=null){
            for(int i=0;i<fs.length;i++){
                if(fs[i].isDirectory()){
                    new File(writePath+"\\"+fs[i].getName()).mkdir();
                    copyAllDir(fs[i].getPath(),writePath+"\\"+fs[i].getName());
                }else{
                    try(FileInputStream readFile=new FileInputStream(fs[i].getPath());
                        FileOutputStream writeFile=new FileOutputStream(writePath+"\\"+fs[i].getName())){
                        byte[] buffer=new byte[1024];
                        int n=0;
                        while((n=readFile.read(buffer))!=-1){
                            writeFile.write(buffer,0,n);
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
