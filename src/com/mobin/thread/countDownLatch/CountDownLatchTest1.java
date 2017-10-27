package com.mobin.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Mobin on 2016/4/14.
 */
public class CountDownLatchTest1 {
    public static long timeTask(int nThreads,final Runnable task) throws InterruptedException {
        //用来保证线程能够同时运行
        final CountDownLatch startGate = new CountDownLatch(1);
        //确保所有任务执行完成才能继续执行
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i =0 ; i < nThreads; i ++){
            Thread t = new Thread(){
                public void run() {
                    try {
                        try {
                            startGate.await();
                        }finally {
                            endGate.countDown();
                        }

                        task.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        System.out.println(end - start);
        return  end - start;
    }

    public static void main(String[] args) {
        try {
            CountDownLatchTest1.timeTask(3,new TaskRunnable());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
