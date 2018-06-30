package com.hangjiang.threads.designmode.guarded_suspension;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by jianghang on 2017/12/3.
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    public synchronized Request getRequest(){
        while (queue.peek() == null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return queue.remove();
    }

    public synchronized void putRequest(Request request){
        queue.offer(request);
        notifyAll();
    }
}
