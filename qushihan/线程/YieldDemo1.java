package com.qushihan.线程;

public class YieldDemo1 extends Thread {
    public YieldDemo1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
            if (i == 30) {
                this.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldDemo1 y1 = new YieldDemo1("张三");
        YieldDemo1 y2 = new YieldDemo1("李四");
        y1.start();
        y2.start();
    }
}
