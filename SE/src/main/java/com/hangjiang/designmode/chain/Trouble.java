package com.hangjiang.designmode.chain;

/**
 * Created by jianghang on 2018/1/7.
 */
public class Trouble {
    private int number;

    public Trouble(int number){
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    @Override
    public String toString() {
        return "Trouble{" +
                "number=" + number +
                '}';
    }
}
