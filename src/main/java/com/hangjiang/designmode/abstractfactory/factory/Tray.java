package com.hangjiang.designmode.abstractfactory.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghang on 2017/12/27.
 */
public abstract class Tray extends Item{
    protected List<Item> tray = new ArrayList<>();

    public Tray(String caption) {
        super(caption);
    }

    public void add(Item item){
        tray.add(item);
    }
}
