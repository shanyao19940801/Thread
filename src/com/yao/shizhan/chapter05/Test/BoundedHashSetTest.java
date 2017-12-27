package com.yao.shizhan.chapter05.Test;

import com.yao.shizhan.chapter05.BoundedHashSet;

import java.util.Set;

/**
 * Created by 单耀 on 2017/12/4.
 */
public class BoundedHashSetTest {
    public static void main(String[] args) throws InterruptedException {
        BoundedHashSet boundedHashSet = new BoundedHashSet(2);
        boundedHashSet.add("1");
        boundedHashSet.add("2");
        boundedHashSet.add("3");

        System.out.println("t");


    }
}
