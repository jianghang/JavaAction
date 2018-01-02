package com.hangjiang.designmode.strategy;

/**
 * Created by jianghang on 2018/1/2.
 */
public interface Strategy {
    Hand nextHand();
    void study(boolean win);
}
