package com.hangjiang.threads;

/**
 * Created by jianghang on 2016/11/24.
 */
public class Run {

    public static void main(String[] args){
        MyThread myThread = new MyThread();
        myThread.start();
        try {
            Thread.sleep(1000);
            myThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
