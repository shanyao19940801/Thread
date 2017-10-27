package com.mobin.thread.countDownLatch;

import com.mobin.thread.untils.SleepUtils;

/**
 * Created by Mobin on 2016/4/14.
 */
public class TaskRunnable implements Runnable {

    public void run() {
//        SleepUtils.secod(5);
        System.out.println("执行Task！！！");
    }
}
