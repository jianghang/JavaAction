package com.hangjiang.designmode.state;

/**
 * Created by jianghang on 2018/1/21.
 */
public interface Context {
    void setClock(int hour);
    void changeState(State state);
    void callSecurityCenter(String msg);
    void recordLog(String msg);
}
