package com.hangjiang.designmode.abstractfactory.tablefactory;

import com.hangjiang.designmode.abstractfactory.factory.Link;

/**
 * Created by jianghang on 2017/12/27.
 */
public class TableLink extends Link{

    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return " <td><a href=\"" + url + "\">" + caption + "</a></td>\n";
    }
}
