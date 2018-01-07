package com.hangjiang.designmode.visitor;

/**
 * Created by jianghang on 2018/1/7.
 */
public interface Element {
    void accept(Visitor visitor);
}
