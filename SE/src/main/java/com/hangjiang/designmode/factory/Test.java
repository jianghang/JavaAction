package com.hangjiang.designmode.factory;

/**
 * Created by jianghang on 2017/4/29.
 */
public class Test {
    public static void main(String[] args){
        IProvider provider = new SendMailFactory();
        ISender sender = provider.produce();
        sender.send();
    }
}
