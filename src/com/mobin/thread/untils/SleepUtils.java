package com.mobin.thread.untils;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 2017/10/27.
 * 等待工具类
 */
public class SleepUtils {
    public static final void secod (long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
