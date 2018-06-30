package com.hangjiang.designmode.singleton;

/**
 * Created by jianghang on 2017/4/29.
 */
public class Singleton {
    private static Singleton instance = null;

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
