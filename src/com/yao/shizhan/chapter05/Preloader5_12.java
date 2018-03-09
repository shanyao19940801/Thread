package com.yao.shizhan.chapter05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by 单耀 on 2017/11/30.
 */
public class Preloader5_12 {
    private final FutureTask<String> future =
            new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("test");
                    return "test";
                }
            }

    );

    private final Thread thread = new Thread(future);

    private void start(){thread.start();}

    public String get() throws Exception {
        try {
            System.out.println("get():"+future.get());
            return future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            throw launderThrowable(cause);
        }
        return "error";
    }

    private static RuntimeException launderThrowable(Throwable cause) {
        if (cause instanceof RuntimeException)
            return (RuntimeException) cause;
        else if (cause instanceof Error)
            throw (Error)cause;
        else
        throw new IllegalStateException("Not unchecked", cause);
    }

    public static void main(String[] args) throws Exception {
        Preloader5_12 preloader5_12 = new Preloader5_12();
        preloader5_12.start();
        System.out.println(preloader5_12.get());
        System.out.println("end");
    }

}
