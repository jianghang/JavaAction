package com.hangjiang.designmode.interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghang on 2018/1/25.
 *
 */
//<command list> ::= <command>* end
public class CommandListNode extends Node{
    private List<Node> list = new ArrayList<>();

    @Override
    public void parse(Context context) throws ParseException {
        while (true){
            if(context.currentToken() == null){
                throw new ParseException("Missing 'end'");
            }else if(context.currentToken().equals("end")){
                context.skipToken("end");
                break;
            }else{
                Node commandNode = new CommandNode();
                commandNode.parse(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public String toString() {
        return list.toString();
    }
}