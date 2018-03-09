package com.yao.shizhan.chapter07;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by 单耀 on 2017/12/27.
 * 
 * 线程任务的取消
 */
public class PrimeGenerator implements Runnable{
    private final List<BigInteger> primes = new ArrayList<>();

    private volatile boolean cacelled;
    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cacelled) {
            p = p.nextProbablePrime();
            primes.add(p);
        }
    }

    public void cancel() {
        cacelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    List<BigInteger> aSecondOfPrimes() {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return generator.get();
    }
}
