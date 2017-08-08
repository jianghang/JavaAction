package com.hangjiang.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Created by jianghang on 2017/5/22.
 */
public class ExchangerDemo {
    private static final Exchanger<List<Integer>> exchanger = new Exchanger<List<Integer>>();

    public static void main(String[] args){
        new Thread(){
            @Override
            public void run() {
                List<Integer> list = new ArrayList<Integer>();
                list.add(1);
                list.add(2);
                try {
                    System.out.println("list: " + list.toString());
                    list = exchanger.exchange(list);
                    System.out.println("list: " + list.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                List<Integer> list1 = new ArrayList<Integer>();
                list1.add(4);
                list1.add(5);
                try {
                    System.out.println("list1: " + list1.toString());
                    list1 = exchanger.exchange(list1);
                    System.out.println("list1: " + list1.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
