package com.hangjiang.threads.designmode.single_threaded_execution;

/**
 * Created by jianghang on 2017/12/3.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Testing Gate,hit CTRL+C to exit;");
        Gate gate = new Gate();
        new UserThread(gate,"Alice","Alaska").start();
        new UserThread(gate,"Bobby","Brazil").start();
        new UserThread(gate,"Chris","Canada").start();
    }
}
