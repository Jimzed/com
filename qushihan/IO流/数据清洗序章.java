package com.qushihan.IO流;

import org.junit.Test;

import java.io.*;

public class 数据清洗序章 {
    @Test
    public void clear() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D://clear_pq.txt")));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D://clear_pqdata.txt")))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] ss = line.split("\t");
                String[] ss1 = ss[0].split("-");
                if (ss1[0].equals("2014")) {
                    String newLine = ss1[0] + ss1[1] + "\t" + ss[1] + "\t" + ss[2];
                    bw.write(newLine, 0, newLine.length());
                    bw.newLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
