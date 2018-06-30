package com.hangjiang.designmode.factory;

/**
 * Created by jianghang on 2017/4/29.
 */
public class SendMailFactory implements IProvider {
    @Override
    public ISender produce() {
        return new MailSender();
    }
}
