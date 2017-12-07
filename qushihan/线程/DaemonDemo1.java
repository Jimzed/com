package com.qushihan.线程;

import java.util.Timer;

public class DaemonDemo1 {
    public static void main(String[] args) {
        D1 d1 = new D1("A");
        D2 d2 = new D2("B");
        d2.setDaemon(true);
        d1.start();
        d2.start();
    }
}

class D1 extends Thread {
    public D1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + ":" + i);
        }
    }
}

class D2 extends Thread {
    public D2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10000; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Timer t = new Timer();
            }
            System.out.println(this.getName() + ":" + i);
        }
    }
}
