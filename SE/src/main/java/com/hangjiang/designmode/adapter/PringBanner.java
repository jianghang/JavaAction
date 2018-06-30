package com.hangjiang.designmode.adapter;

/**
 * Created by jianghang on 2017/12/25.
 */
public class PringBanner extends Banner implements Print{
    public PringBanner(String string){
        super(string);
    }

    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
