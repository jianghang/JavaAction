package com.hangjiang.designmode.state;

/**
 * Created by jianghang on 2018/1/21.
 */
public interface State {
    void doClock(Context context,int hour);
    void doUse(Context context);
    void doAlarm(Context context);
    void doPhone(Context context);
}
