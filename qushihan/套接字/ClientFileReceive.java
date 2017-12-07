package com.qushihan.套接字;

import java.io.*;
import java.net.Socket;

public class ClientFileReceive {
    public static void main(String[] args) {
        Socket client=null;
        DataInputStream dis=null;
        DataOutputStream dos=null;
        try {
            client=new Socket("127.0.0.1",8321);
            dis=new DataInputStream(new BufferedInputStream(client.getInputStream()));
            String fileName=dis.readUTF(); //接受文件名
            File file=new File("D://"+fileName);
            dos=new DataOutputStream(new FileOutputStream(file));
            int len=-1;
            byte[] buffer=new byte[1024];
            while((len=dis.read(buffer))!=-1){
                dos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                dos.flush();
                dos.close();
                dis.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
