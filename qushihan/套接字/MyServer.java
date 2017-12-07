package com.qushihan.套接字;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {// 服务器端

    public static void main(String[] args) {
        // 声明服务器连接对象
        ServerSocket server = null;
        Socket client = null;
        BufferedReader br = null;
        try {
            server = new ServerSocket(9081);
            // 接受客户端字节流数据
            client = server.accept();
            br = new BufferedReader(new InputStreamReader(client.getInputStream()));
            // 解析字节流数据
            boolean flag = true;
            while (flag) {
                String msg = br.readLine();
                if (msg.toLowerCase().equals("exit")) {
                    flag = false;
                    System.out.println("溜了溜了");
                    continue;
                }
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                client.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
