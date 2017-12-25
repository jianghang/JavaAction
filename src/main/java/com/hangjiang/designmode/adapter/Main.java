package com.hangjiang.designmode.adapter;

/**
 * Created by jianghang on 2017/12/25.
 *
 * 使用继承的适配器和使用委托的适配器
 */
public class Main {

    public static void main(String[] args){
        Print print = new PringBanner("Hello");
        print.printWeak();
        print.printStrong();

        PrintTrust printTrust = new PrintBannerTrust("World");
        printTrust.printWeak();
        printTrust.printStrong();
    }
}
