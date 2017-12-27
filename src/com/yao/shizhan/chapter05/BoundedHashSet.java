package com.yao.shizhan.chapter05;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * Created by 单耀 on 2017/12/4.
 * 代码清单5-14
 * 使用Semaphore为容器设置边界
 * 手动写一个带便
 */
public class BoundedHashSet<T> {
    private final Set<T> set;

    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<T>());
        this.sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded)
                sem.release();
        }


    }

    public boolean remove(Objects o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved)
            sem.release();
        return wasRemoved;
    }



}
