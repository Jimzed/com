package com.qushihan.套接字;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        Socket client = null;
        PrintWriter pw = null;
        Scanner scanner = null;
        try {
            client = new Socket("127.0.0.1", 9081);
            pw = new PrintWriter(client.getOutputStream(), true);
            scanner = new Scanner(System.in);
            String words;
            while (scanner.hasNext()) {
                words = scanner.nextLine();
                pw.println(words);
                if (words.toLowerCase().equals("exit")) {
                    System.out.println("不跟你多bb");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                scanner.close();
                pw.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
