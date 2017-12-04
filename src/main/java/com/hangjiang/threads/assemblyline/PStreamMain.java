package com.hangjiang.threads.assemblyline;

/**
 * Created by jianghang on 2017/12/4.
 * 该程序实现了一个算术的流水线，例如：((1000+1000)*1000)/2=1000000.0
 */
public class PStreamMain {
    public static void main(String[] args){
        new Thread(new Plus()).start();
        new Thread(new Multiply()).start();
        new Thread(new Div()).start();

        for(int i = 0;i <= 1000;i++){
            for(int j = 0;j <= 1000;j++){
                Msg msg = new Msg();
                msg.i = i;
                msg.j = j;
                msg.orgStr = "((" + i + "+" + j + ")*" + i + ")/2";
                Plus.blockingQueue.add(msg);
            }
        }
    }
}
