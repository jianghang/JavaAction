package com.hangjiang.IR.hetero;

import com.hangjiang.IR.normalized.Token;

public abstract class ExprNode extends HeteroAST{
    public ExprNode(Token token){
        super(token);
    }
}
