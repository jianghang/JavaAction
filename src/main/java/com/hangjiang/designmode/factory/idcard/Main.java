package com.hangjiang.designmode.factory.idcard;

import com.hangjiang.designmode.factory.framework.Factory;
import com.hangjiang.designmode.factory.framework.Product;

/**
 * Created by jianghang on 2017/12/25.
 */
public class Main {

    public static void main(String[] args){
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("A");
        Product card2 = factory.create("B");
        Product card3 = factory.create("C");
        card1.use();
        card2.use();
        card3.use();
    }
}
