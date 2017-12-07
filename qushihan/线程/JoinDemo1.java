package com.qushihan.线程;

public class JoinDemo1 extends Thread {
    public JoinDemo1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(this.getName() + ":" + i);
            if (i == 50) {
                JoinDemo2 j2 = new JoinDemo2("B");
                j2.start();
                try {
                    j2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        JoinDemo1 j1 = new JoinDemo1("A");
        j1.start();
    }
}

class JoinDemo2 extends Thread {
    public JoinDemo2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(this.getName() + ":" + i);
        }
    }
}
