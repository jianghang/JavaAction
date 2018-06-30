package com.hangjiang.designmode.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jianghang on 2018/1/2.
 */
public class Directory extends Entry {
    private String name;

    private List<Entry> directory = new ArrayList<>();

    public Directory(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()){
            Entry entry = it.next();
            size += entry.getSize();
        }

        return size;
    }

    @Override
    public Iterator iterator() throws FileTreatmentException {
        return directory.iterator();
    }

    public Entry add(Entry entry){
        directory.add(entry);
        entry.parent = this;
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()){
            Entry entry = it.next();
            entry.printList(prefix + "/" + name);
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
