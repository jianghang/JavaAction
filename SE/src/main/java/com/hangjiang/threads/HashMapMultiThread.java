package com.hangjiang.threads;

import scala.Int;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianghang on 2017/12/3.
 * 并发下的hashmap会遇到意想不到的错误，下面这段代码演示了
 */
public class HashMapMultiThread {
    static Map<String,String> map = new HashMap<>();

    public static class AddThread implements Runnable{
        int start = 0;

        public AddThread(int start){
            this.start = start;
        }

        @Override
        public void run() {
            for(int i = 0;i < 100000;i+=2){
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new AddThread(0));
        Thread thread1 = new Thread(new AddThread(1));
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(map.size());
    }
}
