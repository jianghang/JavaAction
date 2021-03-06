package com.hangjiang.threads;


/**
 * Created by jianghang on 2016/11/23.
 */
public class Test {
    public static void main(String[] args){
//        try {
//            MyThread thread = new MyThread();
//            thread.start();
//            for(int i = 0;i < 10;i++){
//                int time = (int) (Math.random() * 1000);
//                Thread.sleep(1000);
//                System.out.println("main=" + Thread.currentThread().getName());
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        ThreadPoolManager.init();
        for(int i = 0;i < 20;i++){
            ThreadPoolManager.runTaskThread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Thread Num: " + Thread.currentThread().getId());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("end");
    }
}
