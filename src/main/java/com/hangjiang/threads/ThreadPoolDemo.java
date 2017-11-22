package com.hangjiang.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jianghang on 2017/11/22.
 */
public class ThreadPoolDemo {
    public static class MyTask implements Runnable{

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        MyTask task = new MyTask();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for(int i = 0;i < 10;i++){
            service.submit(task);
        }
    }
}
