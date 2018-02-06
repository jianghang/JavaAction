package com.hangjiang.backtrack;

import com.hangjiang.lexer.ListLexer;

/**
 * Created by jianghang on 2018/1/31.
 */
public class Main {

    public static void main(String[] args) throws MismatchedTokenException, PreviousParseFailedException {
        String str = "[a,b] = [c,d]";
        ListLexer lexer = new ListLexer(str);
        BacktrackParser parser = new BacktrackParser(lexer);
        parser.stat();
    }
}
