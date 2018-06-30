package com.hangjiang.designmode.factory;

/**
 * Created by jianghang on 2017/4/29.
 */
public class MailSender implements ISender {

    @Override
    public void send() {
        System.out.println("this is MailSender!");
    }
}
