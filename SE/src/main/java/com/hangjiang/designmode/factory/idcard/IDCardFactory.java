package com.hangjiang.designmode.factory.idcard;

import com.hangjiang.designmode.factory.framework.Factory;
import com.hangjiang.designmode.factory.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghang on 2017/12/25.
 */
public class IDCardFactory extends Factory{

    private List<String> owners = new ArrayList<>();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }

    public List<String> getOwners(){
        return owners;
    }
}
