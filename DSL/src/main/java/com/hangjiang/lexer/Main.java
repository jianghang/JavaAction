package com.hangjiang.lexer;

/**
 * Created by jianghang on 2018/1/28.
 */
public class Main {

    public static void main(String[] args){
        ListLexer listLexer = new ListLexer("[a, b]");
        Token token = listLexer.nextToken();
        while (token.type != Lexer.EOF_TYPE){
            System.out.println(token);
            token = listLexer.nextToken();
        }

        System.out.println(token);
    }
}
