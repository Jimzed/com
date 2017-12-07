package com.qushihan.线程;

import org.junit.Test;

public class ThreadGroupDemo1 implements Runnable {
    public static void main(String[] args) {
        new ThreadGroupDemo1().go();
    }

    public void go() {
        ThreadGroup threadGroup1 = new ThreadGroup("父组");
        ThreadGroup threadGroup2 = new ThreadGroup(threadGroup1, "子组");
        Thread t1 = new Thread(threadGroup1, this);
        t1.start();
        Thread t2 = new Thread(threadGroup2, this);
        t2.start();

        Thread[] list = new Thread[threadGroup1.activeCount()];
        int count = threadGroup1.enumerate(list);
        for (int i = 0; i < count; i++) {
            System.out.println(list[i].getName());
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            i++;
        }
        System.out.println(Thread.currentThread().getName() + " finished executing");
    }
}
