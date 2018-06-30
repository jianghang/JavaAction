package com.hangjiang.designmode.abstractfactory.listfactory;

import com.hangjiang.designmode.abstractfactory.factory.Item;
import com.hangjiang.designmode.abstractfactory.factory.Tray;

import java.util.Iterator;

/**
 * Created by jianghang on 2017/12/27.
 */
public class ListTray extends Tray{

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n");
        buffer.append(caption + "\n");
        buffer.append("<ul>\n");
        Iterator<Item> iterator = tray.iterator();
        while (iterator.hasNext()){
            Item item = iterator.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("</li>\n");

        return buffer.toString();
    }
}
