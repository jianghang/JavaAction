package com.hangjiang.designmode.templatemethod;

/**
 * Created by jianghang on 2017/12/25.
 */
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();
    public final void display(){
        open();
        for(int i = 0;i < 5;i++){
            print();
        }
        close();
    }
}
