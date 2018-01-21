package com.hangjiang.designmode.command;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by jianghang on 2018/1/21.
 */
public class MacroCommand implements Command{
    private Stack<Command> commands = new Stack<>();

    @Override
    public void execute() {
        Iterator<Command> iterator = commands.iterator();
        while(iterator.hasNext()){
            iterator.next().execute();
        }
    }

    public void append(Command cmd){
        if(cmd != this){
            commands.push(cmd);
        }
    }

    public void undo(){
        if(!commands.empty()){
            commands.pop();
        }
    }

    public void clear(){
        commands.clear();
    }
}
