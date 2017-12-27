package com.hangjiang.designmode.prototype;

/**
 * Created by jianghang on 2017/12/26.
 */
public interface Product extends Cloneable{

    void use(String s);

    Product createClone();
}
