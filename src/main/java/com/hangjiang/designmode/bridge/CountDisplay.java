package com.hangjiang.designmode.bridge;

/**
 * Created by jianghang on 2017/12/28.
 */
public class CountDisplay extends Display{
    public CountDisplay(DisplayImpl impl){
        super(impl);
    }

    public void multiDisplay(int times){
        open();
        for(int i = 0;i < times;i++){
            print();
        }
        close();
    }
}
