package com.hangjiang.threads.designmode.future;

/**
 * Created by jianghang on 2017/12/3.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("main BEGIN");
        Host host = new Host();
        Data data = host.request(10,'A');
        Data data1 = host.request(20,'B');
        Data data2 = host.request(30,'C');

        System.out.println("main otherJob BEGIN");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main otherJob END");

        System.out.println("data = " + data.getContent());
        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("main END");
    }
}
