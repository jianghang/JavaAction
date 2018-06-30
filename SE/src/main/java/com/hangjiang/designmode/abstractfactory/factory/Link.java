package com.hangjiang.designmode.abstractfactory.factory;

/**
 * Created by jianghang on 2017/12/27.
 */
public abstract class Link extends Item{
    protected String url;

    public Link(String caption,String url) {
        super(caption);
        this.url = url;
    }
}
