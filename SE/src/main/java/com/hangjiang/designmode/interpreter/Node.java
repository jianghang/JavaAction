package com.hangjiang.designmode.interpreter;

/**
 * Created by jianghang on 2018/1/22.
 */
public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
