package com.hangjiang.designmode.facade;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by jianghang on 2018/1/8.
 */
public class PageMaker {
    private PageMaker(){

    }

    public static void makeWelcomePage(String mailaddr,String filename){
        Properties mailprop = Database.getProperties("maildata");
        String username = mailprop.getProperty(mailaddr);
        try {
            HtmlWriter htmlWriter = new HtmlWriter(new FileWriter(filename));
            htmlWriter.title("Welcome to " + username + "'s page!");
            htmlWriter.paragraph(username + "欢迎来到" + username + " 的主页");
            htmlWriter.paragraph("wait for you email");
            htmlWriter.mailto(mailaddr,username);
            htmlWriter.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ") ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
