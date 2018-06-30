package com.hangjiang.java8.defaultmethod;

/**
 * Created by jianghang on 2017/8/31.
 */
public interface IResizable {

    int getWidth();
    int getHeight();

    default boolean isEmpty(){
        return getHeight() == 0 && getHeight() == 0;
    }
}
