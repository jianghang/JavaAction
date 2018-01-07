package com.hangjiang.designmode.chain;

/**
 * Created by jianghang on 2018/1/7.
 */
public class Main {

    public static void main(String[] args){
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob",100);
        Support charlie = new SpecialSupport("Charlie",429);
        alice.setNext(bob).setNext(charlie);

        for(int i = 0;i < 500;i++){
            alice.support(new Trouble(i));
        }
    }
}
