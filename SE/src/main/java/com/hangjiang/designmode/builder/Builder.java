package com.hangjiang.designmode.builder;

/**
 * Created by jianghang on 2017/12/26.
 */
public abstract class Builder {
    public abstract void makeTitle(String title);
    public abstract void makeString(String str);
    public abstract void makeItems(String[] items);
    public abstract void close();
}
