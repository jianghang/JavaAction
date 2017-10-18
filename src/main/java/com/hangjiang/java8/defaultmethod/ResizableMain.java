package com.hangjiang.java8.defaultmethod;

import java.util.List;

public class ResizableMain {

    public static void main(String[] args){
        IResizable resizable = new ResizableImpl();
        System.out.println(resizable.isEmpty());
    }
}
