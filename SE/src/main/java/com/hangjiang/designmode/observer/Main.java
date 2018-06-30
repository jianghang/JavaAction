package com.hangjiang.designmode.observer;

/**
 * Created by jianghang on 2018/1/21.
 */
public class Main {

    public static void main(String[] args){
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
