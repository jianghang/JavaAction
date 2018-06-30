package com.hangjiang.designmode.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianghang on 2018/1/21.
 */
public class BigCharFactory {
    private Map<String,BigChar> pool = new HashMap<>();

    private static BigCharFactory singleton = new BigCharFactory();

    private BigCharFactory(){

    }

    public static BigCharFactory getInstance(){
        return singleton;
    }

    public synchronized BigChar getBigChar(char charname){
        BigChar bc = pool.get("" + charname);
        if(bc == null){
            bc = new BigChar(charname);
            pool.put("" + charname,bc);
        }

        return bc;
    }
}
