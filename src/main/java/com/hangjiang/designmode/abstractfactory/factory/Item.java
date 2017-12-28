package com.hangjiang.designmode.abstractfactory.factory;

/**
 * Created by jianghang on 2017/12/27.
 */
public abstract class Item {
    protected String caption;

    public Item(String caption){
        this.caption = caption;
    }

    public abstract String makeHTML();
}
