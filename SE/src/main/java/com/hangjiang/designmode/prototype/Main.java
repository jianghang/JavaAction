package com.hangjiang.designmode.prototype;

/**
 * Created by jianghang on 2017/12/26.
 * Prototype模式，用于在不指定类名的前提下生成实例
 */
public class Main {

    public static void main(String[] args){
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message",underlinePen);
        manager.register("warning box",mbox);
        manager.register("slash box",sbox);

        Product p1 = manager.create("strong message");
        p1.use("Hello,world.");
        Product p2 = manager.create("warning box");
        p2.use("Hello,world.");
        Product p3 = manager.create("slash box");
        p3.use("Hello,world");
    }
}
