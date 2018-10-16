package com.hangjiang.IR.hetero;

import com.hangjiang.IR.normalized.Token;

public class AddNode extends ExprNode{
    private ExprNode left,right;

    public AddNode(ExprNode left,Token addToken,ExprNode right) {
        super(addToken);
        this.left = left;
        this.right = right;
    }

    public String toStringTree(){
        if(left == null || right == null){
            return this.toString();
        }

        StringBuilder builder = new StringBuilder();
        builder.append("(");
        builder.append(this.toString());
        builder.append(' ');
        builder.append(left.toStringTree());
        builder.append(' ');
        builder.append(right.toStringTree());
        builder.append(")");
        return builder.toString();
    }
}
