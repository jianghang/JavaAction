package com.hangjiang.java8.defaultmethod;

/**
 * Created by jianghang on 2017/8/31.
 */
public class ResizableImpl implements IResizable,IResizable_a {

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
