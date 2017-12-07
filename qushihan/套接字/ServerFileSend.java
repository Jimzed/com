package com.qushihan.套接字;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFileSend {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket client = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            // 服务器连接端口
            server = new ServerSocket(8321);
            client = server.accept();
            File file = new File("D://test//123.txt");
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            dos = new DataOutputStream(client.getOutputStream());
            // 客户端文件名建好
            dos.writeUTF(file.getName());
            dos.flush();
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = dis.read(buffer)) != -1) {
                dos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                dos.flush();
                dos.close();
                dis.close();
                client.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
