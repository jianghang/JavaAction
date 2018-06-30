package com.hangjiang.designmode.decorator;

/**
 * Created by jianghang on 2018/1/3.
 */
public abstract class Border extends Display{
    protected Display display;
    protected Border(Display display){
        this.display = display;
    }
}
