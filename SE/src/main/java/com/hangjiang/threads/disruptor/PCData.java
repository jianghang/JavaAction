package com.hangjiang.threads.disruptor;

/**
 * Created by jianghang on 2017/11/27.
 */
public class PCData {
    private long value;
    public void set(long value){
        this.value = value;
    }

    public long get(){
        return value;
    }
}
