package com.hangjiang.designmode.facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by jianghang on 2018/1/8.
 */
public class Database {
    private Database(){

    }

    public static Properties getProperties(String dbname){
        String filename = dbname + ".txt";
        Properties prop = new Properties();
        try {
            System.out.println(Database.class.getResource("/"));
            prop.load(new FileInputStream(Database.class.getResource("/" + filename).getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }
}
