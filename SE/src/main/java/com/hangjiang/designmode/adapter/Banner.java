package com.hangjiang.designmode.adapter;

/**
 * Created by jianghang on 2017/12/25.
 */
public class Banner {

    private String string;

    public Banner(String string){
        this.string = string;
    }

    public void showWithParen(){
        System.out.println("(" + string + ")");
    }

    public void showWithAster(){
        System.out.println("*" + string + "*");
    }
}
