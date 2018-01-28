package com.hangjiang.lexer;

/**
 * Created by jianghang on 2018/1/28.
 */
public class Token {
    public int type;
    public String text;

    public Token(int type,String text){
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        String tname = ListLexer.tokenNames[type];
        return "<'" + text + "'," + tname + ">";
    }
}
