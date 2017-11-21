package com.hangjiang.threads;

/**
 * Created by jianghang on 2017/11/20.
 */
public class ThreadGroupName implements Runnable{

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true){
            System.out.println("I am " + groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        ThreadGroup threadGroup = new ThreadGroup("PringGroup");
        Thread t1 = new Thread(threadGroup,new ThreadGroupName(),"T1");
        Thread t2 = new Thread(threadGroup,new ThreadGroupName(),"T2");
        t1.start();
        t2.start();
        System.out.println(threadGroup.activeCount());
        threadGroup.list();
    }
}
