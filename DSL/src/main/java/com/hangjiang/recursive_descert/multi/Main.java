package com.hangjiang.recursive_descert.multi;

import com.hangjiang.lexer.ListLexer;

/**
 * Created by jianghang on 2018/1/28.
 */
public class Main {

    public static void main(String[] args){
        ListLexer listLexer = new ListLexer("[a,b = E,c=f,[a,a]]");
        LookaheadParser parser = new LookaheadParser(listLexer,2);
        parser.list();
    }
}
