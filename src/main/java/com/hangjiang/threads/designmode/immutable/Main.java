package com.hangjiang.threads.designmode.immutable;

/**
 * Created by jianghang on 2017/12/3.
 */
public class Main {
    public static void main(String[] args){
        Person alice = new Person("Alice","Alaska");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
    }
}
