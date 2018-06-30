package com.hangjiang.designmode.adapter;

/**
 * Created by jianghang on 2017/12/25.
 *
 * 使用继承的适配器和使用委托的适配器
 */
public class Main {

    public static void main(String[] args){
        //使用继承的是适配器
        Print print = new PringBanner("Hello");
        print.printWeak();
        print.printStrong();

        //使用委托的适配器
        PrintTrust printTrust = new PrintBannerTrust("World");
        printTrust.printWeak();
        printTrust.printStrong();
    }
}
