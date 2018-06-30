package com.hangjiang.designmode.bridge;

/**
 * Created by jianghang on 2017/12/28.
 */
public class CharDisplayImpl extends DisplayImpl{

    private char head;
    private char body;
    private char end;

    public CharDisplayImpl(char head,char body,char end){
        this.head = head;
        this.body = body;
        this.end = end;
    }

    @Override
    public void rawOpen() {
        System.out.print(head);
    }

    @Override
    public void rawPrint() {
        System.out.print(body);
    }

    @Override
    public void rawClose() {
        System.out.println(end);
    }
}
