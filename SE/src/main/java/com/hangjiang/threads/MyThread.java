package com.hangjiang.threads;

/**
 * Created by jianghang on 2016/11/23.
 */
public class MyThread extends Thread {

    private int count = 5;

    public MyThread(){
        System.out.println("Init: " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        try {
            for (int i = 0;i < 500000;i++){
                System.out.println("i=" + (i + 1));

                if(this.interrupted()){
                    System.out.println("I Quit!");
                    throw new InterruptedException();
                }
            }
            System.out.println("I am Run....");
        } catch (InterruptedException e) {
            System.out.println("catch InterruptedException!");
            e.printStackTrace();
        }
    }
}
