package com.hangjiang.designmode.chain;

/**
 * Created by jianghang on 2018/1/7.
 */
public class NoSupport extends Support{

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
