package com.hangjiang.threads.designmode.immutable;

/**
 * Created by jianghang on 2017/12/3.
 */
public class PrintPersonThread extends Thread{
    private Person person;

    public PrintPersonThread(Person person){
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName() + " prints " + person);
        }
    }
}
