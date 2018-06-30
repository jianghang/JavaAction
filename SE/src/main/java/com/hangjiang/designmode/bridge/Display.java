package com.hangjiang.designmode.bridge;

/**
 * Created by jianghang on 2017/12/28.
 */
public class Display {
    private DisplayImpl impl;

    public Display(DisplayImpl impl){
        this.impl = impl;
    }

    public void open(){
        impl.rawOpen();
    }

    public void print(){
        impl.rawPrint();
    }

    public void close(){
        impl.rawClose();
    }

    public final void display(){
        open();
        print();
        close();
    }
}
