package com.hangjiang.threads;

/**
 * Created by jianghang on 2017/11/20.
 */

public class PlusTask implements Runnable{

    private static volatile int i;

    @Override
    public void run() {
        for(int k = 0;k < 10000;k++){
            i++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i = 0;i < 10;i++){
            threads[i] = new Thread(new PlusTask());
            threads[i].start();
        }
        for(int i = 0;i < 10;i++){
            threads[i].join();
        }

        System.out.println(i);
    }
}
