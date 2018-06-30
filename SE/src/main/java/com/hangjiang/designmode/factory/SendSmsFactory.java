package com.hangjiang.designmode.factory;

/**
 * Created by jianghang on 2017/4/29.
 */
public class SendSmsFactory implements IProvider {
    @Override
    public ISender produce() {
        return new SmsSender();
    }
}
