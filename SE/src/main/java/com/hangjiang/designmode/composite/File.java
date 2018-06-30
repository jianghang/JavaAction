package com.hangjiang.designmode.composite;

/**
 * Created by jianghang on 2018/1/2.
 */
public class File extends Entry{
    private String name;
    private int size;

    public File(String name,int size){
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
    }
}
