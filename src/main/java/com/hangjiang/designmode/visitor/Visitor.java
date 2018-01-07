package com.hangjiang.designmode.visitor;

/**
 * Created by jianghang on 2018/1/7.
 */
public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
