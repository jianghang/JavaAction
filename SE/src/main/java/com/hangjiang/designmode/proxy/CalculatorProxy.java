package com.hangjiang.designmode.proxy;

/**
 * Created by jianghang on 2017/5/22.
 */
public class CalculatorProxy implements Calculator {

    private Calculator calculator;

    public CalculatorProxy(Calculator calculator){
        this.calculator = calculator;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("Proxy: --------------");
        int result = calculator.add(a,b);
        return result;
    }

    public static void main(String[] args){
        Calculator calculator = new CalculatorImpl();
        CalculatorProxy calculatorProxy = new CalculatorProxy(calculator);
        int result = calculatorProxy.add(1,2);
        System.out.println(result);
    }
}
