package com.hangjiang.designmode.interpreter;

/**
 * Created by jianghang on 2018/1/25.
 */
//<repeat command> ::= repeat <number> <command list>
public class RepeatCommandNode extends Node{
    private int number;
    private Node commandListNode;

    @Override
    public void parse(Context context) throws ParseException {
        context.skipToken("repeat");
        number = context.currentNumber();
        context.nextToken();
        commandListNode = new CommandListNode();
        commandListNode.parse(context);
    }

    @Override
    public String toString() {
        return "[repeat " + number + " " + commandListNode + "]";
    }
}
