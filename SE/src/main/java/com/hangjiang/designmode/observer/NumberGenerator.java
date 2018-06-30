package com.hangjiang.designmode.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jianghang on 2018/1/21.
 */
public abstract class NumberGenerator {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void deleteObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()){
            Observer observer = iterator.next();
            observer.update(this);
        }
    }

    public abstract int getNumber();
    public abstract void execute();
}
