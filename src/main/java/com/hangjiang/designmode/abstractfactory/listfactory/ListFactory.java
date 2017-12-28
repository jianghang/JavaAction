package com.hangjiang.designmode.abstractfactory.listfactory;

import com.hangjiang.designmode.abstractfactory.factory.Factory;
import com.hangjiang.designmode.abstractfactory.factory.Link;
import com.hangjiang.designmode.abstractfactory.factory.Page;
import com.hangjiang.designmode.abstractfactory.factory.Tray;

/**
 * Created by jianghang on 2017/12/27.
 */
public class ListFactory extends Factory{

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title,author);
    }
}
