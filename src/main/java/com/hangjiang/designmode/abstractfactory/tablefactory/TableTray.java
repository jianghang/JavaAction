package com.hangjiang.designmode.abstractfactory.tablefactory;

import com.hangjiang.designmode.abstractfactory.factory.Item;
import com.hangjiang.designmode.abstractfactory.factory.Tray;

import java.util.Iterator;

/**
 * Created by jianghang on 2017/12/27.
 */
public class TableTray extends Tray{

    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<td>");
        buffer.append("<table width=\"100%\" border=\"1\"><tr>");
        buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\"" + tray.size() + "\"><b>" + caption + "</b></td>");

        buffer.append("</tr>\n");
        buffer.append("<tr>\n");
        Iterator<Item> iterator = tray.iterator();
        while (iterator.hasNext()){
            Item item = iterator.next();
            buffer.append(item.makeHTML());
        }
        buffer.append("</tr></table>");
        buffer.append("</td>");

        return buffer.toString();
    }
}
