package com.hangjiang.designmode.proxy;

/**
 * Created by jianghang on 2017/5/22.
 */
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
