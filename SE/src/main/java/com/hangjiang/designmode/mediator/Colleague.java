package com.hangjiang.designmode.mediator;

/**
 * Created by jianghang on 2018/1/8.
 */
public interface Colleague {
    void setMediator(Mediator mediator);
    void setColleagueEnabled(boolean enabled);
}
