package com.qushihan.编译原理;

import java.io.*;
import java.util.Scanner;

public class Comment2 {
    public static void main(String[] args) throws IOException {
        File fileSource = new File("D:\\test\\commentsrc.txt");
        File fileTarget = new File("D:\\test\\commenttar.txt");
        BufferedReader br = new BufferedReader(new FileReader(fileSource));
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileTarget));
        Scanner in = new Scanner(br);
        while (in.hasNext()) {
            String str = in.nextLine();
            StringBuffer sb = new StringBuffer(str);
            int i, j;
            if ((i = sb.indexOf("/*")) != -1 && (j = sb.indexOf("*/")) != -1)
                sb.delete(i, j + 2);
            else if (i != -1) {
                sb.delete(i, sb.length());
                bw.write(sb.toString());
                bw.write("\r\n");
                bw.flush();
                do {
                    if (in.hasNext()) {
                        str = in.nextLine();
                        sb = new StringBuffer(str);
                    } else
                        sb = null;
                } while ((i = sb.indexOf("*/")) == -1);
                if (in.hasNext()) {
                    str = in.nextLine();
                    sb = new StringBuffer(str);
                } else
                    sb = null;
            }
            if ((i = sb.indexOf("//")) != -1)
                sb.delete(i, sb.length());
            if (sb != null) {
                if ((i = sb.indexOf("/*")) != -1 && (j = sb.indexOf("*/")) != -1)
                    sb.delete(i, j + 2);
                bw.write(sb.toString());
                bw.write("\r\n");
                bw.flush();
            }
        }
        br.close();
        bw.close();
    }
}