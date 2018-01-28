package com.hangjiang.recursive_descert;

import com.hangjiang.lexer.Lexer;
import com.hangjiang.lexer.Token;

/**
 * Created by jianghang on 2018/1/28.
 */
public class Parser {
    protected Lexer input;
    protected Token lookahead;

    public Parser(Lexer input){
        this.input = input;
        lookahead = input.nextToken();
    }

    public void match(int x){
        if(lookahead.type == x){
            consume();
        }else{
            throw new Error("expecting " + input.getTokenName(x) + "; found " + lookahead);
        }
    }

    public void consume() {
        lookahead = input.nextToken();
    }
}
