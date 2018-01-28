package com.hangjiang.recursive_descert.multi;

import com.hangjiang.lexer.Lexer;
import com.hangjiang.lexer.Token;

/**
 * Created by jianghang on 2018/1/28.
 */
public class Parser {
    private Lexer input;
    private Token[] lookahead;
    private int k;
    private int p = 0;

    public Parser(Lexer input,int k){
        this.input = input;
        this.k = k;
        lookahead = new Token[k];
        for(int i = 1;i <= k;i++){
            consume();
        }
    }

    public void consume(){
        lookahead[p] = input.nextToken();
        p = (p + 1) % k;
    }

    public Token LT(int i){
        return lookahead[(p + i - 1) % k];
    }

    public int LA(int i){
        return LT(i).type;
    }

    public void match(int x){
        System.out.println(LT(1).toString());
        if(LA(1) == x){
            consume();
        }else {
            throw new Error("expecting " + input.getTokenName(x) + "; found " + LT(1));
        }
    }
}
