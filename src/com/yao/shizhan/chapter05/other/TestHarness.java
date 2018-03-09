package com.yao.shizhan.chapter05.other;

import java.util.concurrent.CountDownLatch;

/**
 * Created by 单耀 on 2017/11/29.
 * 代码清单5-11
 */
public class TestHarness {
    public long timeTasks(int nThreads, Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread thread= new Thread() {
              public void run() {
                  try {
                      startGate.await();
                      task.run();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  } finally {
                      endGate.countDown();
                  }
              }
            };
            thread.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        TestHarness testHarness = new TestHarness();
        try {
            System.out.println(testHarness.timeTasks(10,new TestTask()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class TestTask implements Runnable{

        @Override
        public void run() {
            System.out.println("test print out");
        }
    }
}
