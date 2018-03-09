package com.yao.othertest;

/**
 * Created by 单耀 on 2017/12/6.
 */
public class Main {
    public static void main(String[] args) {
        A ab= new B();
        A ac = new C();
        B bb = new B();
        C cc = new C();
        System.out.println(ab instanceof A);
        System.out.println(ab instanceof B);
        System.out.println(ac instanceof A);
        System.out.println(ac instanceof B);
        System.out.println(ac instanceof C);
        System.out.println(cc instanceof A);
        System.out.println(cc instanceof B);
    }
}
