package com.hangjiang.threads.assemblyline;

/**
 * Created by jianghang on 2017/12/4.
 * 该程序实现了一个算术的流水线，例如：((1000+1000)*1000)/2=1000000.0
 */
public class PStreamMain {
    public static void main(String[] args) throws InterruptedException {
        Thread plusThread = new Thread(new Plus());
        Thread multiplyThread = new Thread(new Multiply());
        Thread divThread = new Thread(new Div());
        plusThread.start();
//        multiplyThread.start();
//        divThread.start();

        for(int i = 0;i <= 10;i++){
            for(int j = 0;j <= 10;j++){
                Msg msg = new Msg();
                msg.i = i;
                msg.j = j;
                msg.orgStr = "((" + i + "+" + j + ")*" + i + ")/2";
                Plus.blockingQueue.add(msg);
            }
        }

        System.out.println(plusThread.getState().name());
        boolean isRun = true;
        while (isRun){
            Thread.sleep(5000);
            String state = plusThread.getState().name();
            System.out.println(state);
            if("WAITING".equals(state)){
                plusThread.interrupt();
                isRun = false;
            }
        }
    }
}
