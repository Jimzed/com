package com.qushihan.线程;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo1 {
    @Test
    public void go1() {
        // 固定线程池
        ExecutorService service = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 10; i++) {
            System.out.println("创建线程" + i);
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "启动线程");
                }
            });
        }
        service.shutdown();
        try {
            service.awaitTermination(10000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void go2() {
        // 缓冲线程池
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            System.out.println("创建线程" + i);
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "启动线程");
                }
            });
        }
        service.shutdown();
        try {
            service.awaitTermination(10000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void go3() {
        // 单一线程
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 100; i++) {
            System.out.println("创建线程" + i);
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "启动线程");
                }
            });
        }
        service.shutdown();
        try {
            service.awaitTermination(10000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
