package com.qushihan.线程;

public class RunnableDemo2 {
    public static void main(String[] args) {
        B b1 = new B();
        B b2 = new B();
        Thread t1 = new Thread(b1);
        Thread t2 = new Thread(b2);
        t1.start();
        t2.start();
    }
}

class B implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
