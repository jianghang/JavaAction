package com.hangjiang.designmode.abstractfactory;

import com.hangjiang.designmode.abstractfactory.factory.Factory;
import com.hangjiang.designmode.abstractfactory.factory.Link;
import com.hangjiang.designmode.abstractfactory.factory.Page;
import com.hangjiang.designmode.abstractfactory.factory.Tray;

/**
 * Created by jianghang on 2017/12/27.
 */
public class Main {

    public static void main(String[] args){
//        if(args.length != 1){
//            System.out.println("Usage: java Main class.name.of.ConcreateFactory");
//            System.out.println("Example 1: java Main listfactory.ListFactory");
//            System.out.println("Example 2: java Main tablefactory.TableFactory");
//            System.exit(0);
//        }

//        Factory factory = Factory.getFactory("com.hangjiang.designmode.abstractfactory.listfactory.ListFactory");
        Factory factory = Factory.getFactory("com.hangjiang.designmode.abstractfactory.tablefactory.TableFactory");

        Link people = factory.createLink("人民日报","http://www.people.com.cn/");
        Link gmw = factory.createLink("光明日报","http://www.gmv.cn/");

        Link us_yahoo = factory.createLink("Yahoo!","http://www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo!Japan","http://www.yahoo.co.jp");
        Link excite = factory.createLink("Excite","http://www.excite.com/");
        Link google = factory.createLink("Google","http://www.google.com/");

        Tray traynews = factory.createTray("日报");
        traynews.add(people);
        traynews.add(gmw);

        Tray trayyahoo = factory.createTray("Yahoo!");
        trayyahoo.add(us_yahoo);
        trayyahoo.add(jp_yahoo);

        Tray traysearch = factory.createTray("检索引擎");
        traysearch.add(trayyahoo);
        traysearch.add(excite);
        traysearch.add(google);

        Page page = factory.createPage("LinkPage","杨文轩");
        page.add(traynews);
        page.add(traysearch);
        page.output();
    }
}
