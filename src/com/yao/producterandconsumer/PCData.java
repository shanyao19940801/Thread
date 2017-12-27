package com.yao.producterandconsumer;

/**
 * Created by 单耀 on 2017/12/10.
 */
public class PCData {
    private final int intData;

    public PCData(int d) {
        intData = d;
    }
    public PCData(String d) {
        intData = Integer.valueOf(d);
    }
    public int getData(){
        return intData;
    }

    @Override
    public String toString() {
        return "PCData{" +
                "intData=" + intData +
                '}';
    }
}
