package com.hangjiang.designmode.chain;

/**
 * Created by jianghang on 2018/1/7.
 */
public class SpecialSupport extends Support{
    private int number;

    public SpecialSupport(String name,int number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if(trouble.getNumber() == number){
            return true;
        }else{
            return false;
        }
    }
}
