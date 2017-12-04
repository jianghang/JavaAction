package com.hangjiang.threads.designmode.future;

/**
 * Created by jianghang on 2017/12/3.
 */
public class FutureData implements Data{
    private RealData realData = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realData){
        if(ready){
            return;
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }

    @Override
    public synchronized String getContent() {
        while (!ready){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return realData.getContent();
    }
}
