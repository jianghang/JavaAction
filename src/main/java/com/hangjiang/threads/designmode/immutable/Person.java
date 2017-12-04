package com.hangjiang.threads.designmode.immutable;

/**
 * Created by jianghang on 2017/12/3.
 */
public class Person {
    private final String name;
    private final String address;

    public Person(String name,String address){
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
