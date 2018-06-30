package com.hangjiang.designmode.decorator;

/**
 * Created by jianghang on 2018/1/3.
 * 装饰者模式
 */
public class Main {

    public static void main(String[] args){
        MultiStringDisplay multiStringDisplay = new MultiStringDisplay();
        multiStringDisplay.add("hello");
        multiStringDisplay.add("yyyyyyyyyyy");
        Display multiDisplay = new SideBorder(multiStringDisplay,'#');
        multiDisplay.show();
        Display b1 = new StringDisplay("Hello,world.");
        Display b5 = new UpDownBorder(b1,'-');
        b5.show();
        Display b2 = new SideBorder(b1,'#');
        Display b3 = new FullBorder(multiDisplay);
        b1.show();
        b2.show();
        b3.show();

        Display b4 = new SideBorder(new FullBorder(new FullBorder(new SideBorder(new FullBorder(new StringDisplay("Hello,World.")),'*'))),'/');
        b4.show();
    }
}
