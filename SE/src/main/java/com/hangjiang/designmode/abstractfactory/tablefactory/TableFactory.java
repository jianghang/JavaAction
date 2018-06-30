package com.hangjiang.designmode.abstractfactory.tablefactory;

import com.hangjiang.designmode.abstractfactory.factory.Factory;
import com.hangjiang.designmode.abstractfactory.factory.Link;
import com.hangjiang.designmode.abstractfactory.factory.Page;
import com.hangjiang.designmode.abstractfactory.factory.Tray;

/**
 * Created by jianghang on 2017/12/27.
 */
public class TableFactory extends Factory{

    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title,author);
    }
}
