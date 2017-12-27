package com.hangjiang.designmode.prototype;

import java.util.HashMap;

/**
 * Created by jianghang on 2017/12/26.
 */
public class Manager {

    private HashMap<String,Product> showcase = new HashMap<>();

    public void register(String name,Product proto){
        showcase.put(name,proto);
    }

    public Product create(String protoname){
        Product p = showcase.get(protoname);
        return p.createClone();
    }
}
