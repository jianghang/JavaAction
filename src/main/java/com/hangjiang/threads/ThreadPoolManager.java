package com.hangjiang.threads;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jianghang on 2017/9/6.
 */
public class ThreadPoolManager {

    private static ThreadPoolExecutor poolExecutor;

    public static void init(){
        int maxCallNum = 2;

        poolExecutor = new ThreadPoolExecutor(maxCallNum,
                maxCallNum,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1),
                new ThreadPoolExecutor.CallerRunsPolicy());

    }

    public static void runTaskThread(Runnable runnable){
        poolExecutor.execute(runnable);
    }


    public static void stop(){
        if(poolExecutor != null){
            poolExecutor.shutdown();
        }
    }

}
