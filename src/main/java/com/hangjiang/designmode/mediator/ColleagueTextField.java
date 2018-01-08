package com.hangjiang.designmode.mediator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * Created by jianghang on 2018/1/8.
 */
public class ColleagueTextField extends TextField implements TextListener,Colleague{
    private Mediator mediator;

    public ColleagueTextField(String text,int columns){
        super(text,columns);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        setBackground(enabled ? Color.white : Color.lightGray);
    }

    @Override
    public void textValueChanged(TextEvent e) {
        mediator.colleagueChanged();
    }
}
