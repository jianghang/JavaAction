package com.hangjiang.IR.hetero;

import com.hangjiang.IR.normalized.Token;

public class HeteroAST {
    Token token;

    public HeteroAST(){

    }

    public HeteroAST(Token token){
        this.token = token;
    }

    public HeteroAST(int tokenType){
        this.token = new Token(tokenType);
    }

    @Override
    public String toString() {
        return token.toString();
    }

    public String toStringTree(){
        return toString();
    }
}
