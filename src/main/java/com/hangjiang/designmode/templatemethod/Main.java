package com.hangjiang.designmode.templatemethod;

/**
 * Created by jianghang on 2017/12/25.
 * 模版方法
 */
public class Main {

    public static void main(String[] srgs){
        AbstractDisplay abstractDisplay = new CharDisplay('H');
        AbstractDisplay abstractDisplay1 = new StringDisplay("Hello,world.");
        AbstractDisplay abstractDisplay2 = new StringDisplay("你好，世界");

        abstractDisplay.display();
        abstractDisplay1.display();
        abstractDisplay2.display();
    }
}
