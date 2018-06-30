package com.hangjiang.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by jianghang on 2017/12/7.
 */
public class AskThread implements Runnable {
    CompletableFuture<Integer> completableFuture = null;

    public AskThread(CompletableFuture<Integer> completableFuture){
        this.completableFuture = completableFuture;
    }

    @Override
    public void run() {
        int myRe = 0;
        try {
            myRe = completableFuture.get() * completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(myRe);
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();

        Thread.sleep(2000);
        future.complete(60);
    }
}
