package com.hangjiang.recursive_descert;

import com.hangjiang.lexer.ListLexer;

/**
 * Created by jianghang on 2018/1/28.
 */
public class Main {

    public static void main(String[] args){
        ListLexer listLexer = new ListLexer("[a,B,o,[o,i]]");
        ListParser listParser = new ListParser(listLexer);
        listParser.list();
    }
}
