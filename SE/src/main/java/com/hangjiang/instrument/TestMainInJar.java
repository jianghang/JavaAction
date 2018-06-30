package com.hangjiang.instrument;

/**
 * Created by jianghang on 2018/1/14.
 */
public class TestMainInJar {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new TransClass().getNumbers());

        int count = 0;
        while(true){
            Thread.sleep(1000);
            count++;
            int number = new TransClass().getNumbers();
            System.out.println("Number: " + number + " count: " + count);
        }
    }
}
