package com.hangjiang.designmode.bridge;

/**
 * Created by jianghang on 2017/12/28.
 */
public class Main {

    public static void main(String[] args){
        Display d1 = new Display(new StringDisplayImpl("Hello,China"));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello,World."));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello,Universe."));
        IncreaseDisplay increaseDisplay = new IncreaseDisplay(new CharDisplayImpl('<','*','>'),1);
        IncreaseDisplay increaseDisplay1 = new IncreaseDisplay(new CharDisplayImpl('|','#','-'),2);

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);
        increaseDisplay.increaseDisplay(4);
        increaseDisplay1.increaseDisplay(5);
    }
}