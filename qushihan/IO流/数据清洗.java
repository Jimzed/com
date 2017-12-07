package com.qushihan.IO流;

import org.junit.Test;

import java.io.*;

public class 数据清洗 {
    @Test
    public void clear() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D://product_quantity.txt")));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D://clear_pq.txt")))) {
            int count = 0;
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] ss = line.split(",");
                if (Integer.parseInt(ss[7]) < 0 || Integer.parseInt(ss[8]) < 0) {
                    continue;
                }
                String newLine = ss[1] + "\t" + ss[7] + "\t" + ss[8];
                bw.write(newLine, 0, newLine.length());
                bw.newLine();//换行
                count++;
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
