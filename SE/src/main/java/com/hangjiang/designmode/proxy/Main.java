package com.hangjiang.designmode.proxy;

/**
 * Created by jianghang on 2018/1/21.
 */
public class Main {

    public static void main(String[] args){
        Printable printable = new PrinterProxy("Alice");
        System.out.println("现在的名字是 " + printable.getPrinterName() + ".");
        printable.setPrinterName("Bob");
        System.out.println("现在的名字是 " + printable.getPrinterName() + ".");
        printable.print("Hello,world!");
    }
}
