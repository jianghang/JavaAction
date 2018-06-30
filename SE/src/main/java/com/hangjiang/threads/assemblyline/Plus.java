package com.hangjiang.threads.assemblyline;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jianghang on 2017/12/4.
 */
public class Plus implements Runnable{
    public static BlockingQueue<Msg> blockingQueue = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        boolean isRun = true;
        while (isRun){
            try {
                Msg msg = blockingQueue.take();
                msg.j = msg.i + msg.j;
                Thread.sleep(200);
                System.out.println(msg.j);

                Multiply.blockingQueue.add(msg);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
                isRun = false;
                e.printStackTrace();
            }
        }
    }
}
