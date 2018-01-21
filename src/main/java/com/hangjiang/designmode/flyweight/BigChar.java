package com.hangjiang.designmode.flyweight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by jianghang on 2018/1/21.
 */
public class BigChar {
    private char charname;

    private String fontdata;

    public BigChar(char charname){
        this.charname = charname;
        try {
            String path = this.getClass().getClassLoader().getResource("").getPath();
            BufferedReader reader = new BufferedReader(new FileReader(path + "big" + charname + ".txt"));
            String line;
            StringBuffer buffer = new StringBuffer();
            while ((line = reader.readLine()) != null){
                buffer.append(line);
                buffer.append("\n");
            }
            reader.close();
            this.fontdata = buffer.toString();
        } catch (IOException e) {
            this.fontdata = charname + "?";
            e.printStackTrace();
        }
    }

    public void print(){
        System.out.println(fontdata);
    }

    public static void main(String[] args){
        new BigChar('1').print();
    }
}
