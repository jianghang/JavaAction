package com.hangjiang.backtrack;

import com.hangjiang.lexer.Lexer;
import com.hangjiang.lexer.Token;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghang on 2018/1/28.
 */
public class Parser {
    private Lexer input;
    private List<Integer> markers;
    private List<Token> lookahead;
    private int p = 0;

    public Parser(Lexer input){
        this.input = input;
        lookahead = new ArrayList<>();
        markers = new ArrayList<>();
    }

    public void consume(){
        p++;
        if(p == lookahead.size() && !isSpeculating()){
            p = 0;
            lookahead.clear();
        }
        sync(1);
    }

    public boolean isSpeculating() {
        return markers.size() > 0;
    }

    public int mark(){
        markers.add(p);
        return p;
    }

    public void release(){
        int marker = markers.get(markers.size() - 1);
        markers.remove(markers.size() - 1);
        seek(marker);
    }

    public void seek(int index) {
        p = index;
    }

    public Token LT(int i){
        sync(i);
        return lookahead.get(p + i - 1);
    }

    public void sync(int i) {
        if(p + i - 1 > (lookahead.size() - 1)){
            int n = (p + i - 1) - (lookahead.size() - 1);
            fill(n);
        }
    }

    private void fill(int n) {
        for(int i = 1;i <= n;i++){
            lookahead.add(input.nextToken());
        }
    }

    public int LA(int i){
        return LT(i).type;
    }

    public void match(int x) throws MismatchedTokenException {
        System.out.println(LT(1).toString());
        if(LA(1) == x){
            consume();
        }else {
            throw new MismatchedTokenException("expecting " + input.getTokenName(x) + " found " + LT(1));
        }
    }
}
