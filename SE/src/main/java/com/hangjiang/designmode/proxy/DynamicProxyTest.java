package com.hangjiang.designmode.proxy;

import java.lang.reflect.Proxy;

/**
 * Created by jianghang on 2017/5/22.
 */
public class DynamicProxyTest {
    public static void main(String[] args){
        Calculator calculator = new CalculatorImpl();
        LogHandler logHandler = new LogHandler(calculator);
        Calculator proxy = (Calculator) Proxy.newProxyInstance(calculator.getClass().getClassLoader(),calculator.getClass().getInterfaces(),logHandler);
        proxy.add(1,2);
    }
}
