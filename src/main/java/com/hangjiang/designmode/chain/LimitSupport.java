package com.hangjiang.designmode.chain;

/**
 * Created by jianghang on 2018/1/7.
 */
public class LimitSupport extends Support{

    private int limit;

    public LimitSupport(String name,int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() < limit){
            return true;
        }else{
            return false;
        }
    }
}
