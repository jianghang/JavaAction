package com.hangjiang.threads.designmode.guarded_suspension;

/**
 * Created by jianghang on 2017/12/3.
 */
public class Request {
    private final String name;

    public Request(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                '}';
    }
}
