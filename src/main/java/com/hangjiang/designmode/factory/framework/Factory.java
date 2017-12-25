package com.hangjiang.designmode.factory.framework;

/**
 * Created by jianghang on 2017/12/25.
 */
public abstract class Factory {
    public final Product create(String owner){
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }

    protected abstract Product createProduct(String owner);
    protected abstract void registerProduct(Product product);
}
