package com.hangjiang.designmode.mediator;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by jianghang on 2018/1/8.
 */
public class ColleagueCheckbox extends Checkbox implements ItemListener,Colleague{
    private Mediator mediator;

    public ColleagueCheckbox(String caption,CheckboxGroup group,boolean state){
        super(caption,group,state);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
    }
}
