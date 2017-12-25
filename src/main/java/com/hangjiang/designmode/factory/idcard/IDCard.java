package com.hangjiang.designmode.factory.idcard;

import com.hangjiang.designmode.factory.framework.Product;

/**
 * Created by jianghang on 2017/12/25.
 */
public class IDCard extends Product{

    private String owner;

    public IDCard(String owner){
        this.owner = owner;
        System.out.println("制作" + owner + "的ID卡");
    }

    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡");
    }

    public String getOwner(){
        return owner;
    }
}
