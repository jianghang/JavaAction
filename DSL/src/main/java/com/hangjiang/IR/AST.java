package com.hangjiang.IR;

import java.util.ArrayList;
import java.util.List;

public class AST {
    public Token token;
    List<AST> children;

    public AST(){

    }

    public AST(Token token){
        this.token = token;
    }

    public AST(int tokenType){
        this.token = new Token(tokenType);
    }

    public int getNodeType(){
        return token.type;
    }

    public void addChild(AST t){
        if(children == null){
            children = new ArrayList<>();
        }
        children.add(t);
    }

    public boolean isNil(){
        return token == null;
    }

    @Override
    public String toString() {
        return token != null ? token.toString() : "nil";
    }

    public String toStringTree(){
        if(children == null || children.size() == 0){
            return this.toString();
        }

        StringBuilder builder = new StringBuilder();
        if(!isNil()){
            builder.append("(");
            builder.append(this.toString());
            builder.append(' ');
        }

        for(int i = 0;i < children.size();i++){
            AST t = children.get(i);
            if(i > 0){
                builder.append(' ');
            }
            builder.append(t.toStringTree());
        }

        if(!isNil()){
            builder.append(")");
        }

        return builder.toString();
    }
}
