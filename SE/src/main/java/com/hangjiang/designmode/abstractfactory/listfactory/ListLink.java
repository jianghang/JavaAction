package com.hangjiang.designmode.abstractfactory.listfactory;

import com.hangjiang.designmode.abstractfactory.factory.Link;

/**
 * Created by jianghang on 2017/12/27.
 */
public class ListLink extends Link{

    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return " <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
