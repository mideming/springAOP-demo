package com.example.demo.multithread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: mideming
 * @create: 2019-04-26 14:33
 **/
public class MultiThreadDemo {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static ExecutorService executorService = Executors.newFixedThreadPool(2);
//    public static void main(String[] args) throws InterruptedException {
//        CountDownLatch latch = new CountDownLatch(4);
//        for (int i = 0; i < 4; i ++) {
//            String name = "aaa" + i;
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    doSomething(name, 3000L, latch);
//                }
//            });
//        }
//
//        System.out.println("等待两个子线程执行完毕");
//        latch.await();
//        System.out.println("2个子线程执行完毕");
//        System.out.println("继续执行主线程");
//
//    }
    public static void doSomething(String name,Long time,CountDownLatch latch) {
        System.out.println(name + "开始工作：" + sdf.format(new Date()));
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "结束工作：" + sdf.format(new Date()));
        latch.countDown();

    }

    public static void main(String[] args)
    {
        Clerk clerk = new Clerk();
        Thread producerThread = new Thread(new Producer(clerk));
        Thread consumerThread = new Thread(new Consumer(clerk));

        producerThread.start();
        consumerThread.start();
    }
    static class Producer implements Runnable{
        private Clerk clerk;
        public Producer (Clerk clerk) {
            this.clerk = clerk;
        }
        @Override
        public void run() {
            System.out.println("生产者开始生产产品");
            while(true)
            {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                clerk.addProduct();
            }
        }
    }

    static class Consumer implements Runnable {
        private Clerk clerk;

        public Consumer(Clerk clerk) {
            this.clerk = clerk;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            System.out.println("消费者开始消费产品");
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                clerk.getProduct();
            }

        }
    }
    static class Clerk{
        private static final int MAX_PRODUCT = 20;
        private static final int MIN_PRODUCT = 0;
        private int PRODUCT = 0;
        public synchronized void addProduct () {
            if(this.PRODUCT >= MAX_PRODUCT) {
                try {
                    wait();
                    System.out.println("产品已满，请稍后再生产");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.PRODUCT ++;
            System.out.println("生产者生产了第" + this.PRODUCT + "个产品");
            notifyAll();
        }
        public synchronized void getProduct () {
            if(this.PRODUCT <= MIN_PRODUCT) {
                try {
                    wait();
                    System.out.println("产品处于缺货状态");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.PRODUCT--;
            System.out.println("消费者消费了第" + this.PRODUCT + "个产品");
            notifyAll();
        }
    }
}
