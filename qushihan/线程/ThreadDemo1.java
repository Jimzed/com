package com.qushihan.线程;

public class ThreadDemo1 {
    public static void main(String[] args) {
        A a1 = new A();
        a1.setName("a1");// 为当前线程设置名称
//        a1.setPriority(Thread.MAX_PRIORITY);// 设置优先级1--10
        a1.start();
        A a2 = new A();
        a2.setName("a2");
        a2.start();
    }
}

class A extends Thread {
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
