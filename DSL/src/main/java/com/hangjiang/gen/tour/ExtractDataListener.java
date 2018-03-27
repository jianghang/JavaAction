package com.hangjiang.gen.tour;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by jianghang on 2018/3/27.
 */
public class ExtractDataListener implements DataListener{


    @Override
    public void enterFile(DataParser.FileContext ctx) {
        System.out.println("enterFile: " + ctx.getText());
    }

    @Override
    public void exitFile(DataParser.FileContext ctx) {
        System.out.println("exitFile: " + ctx.getText());
    }

    @Override
    public void enterGroup(DataParser.GroupContext ctx) {
        System.out.println("enterGroup: " + ctx.getText());
        System.out.println(ctx.INT.getText());
        for(TerminalNode node : ctx.sequence().INT()){
            System.out.print(node.getText());
            System.out.print(" ");
        }
        System.out.println();
    }

    @Override
    public void exitGroup(DataParser.GroupContext ctx) {
        System.out.println("exitGroup: " + ctx.getText());
    }

    @Override
    public void enterSequence(DataParser.SequenceContext ctx) {
        System.out.println("enterSequence: " + ctx.getText());
    }

    @Override
    public void exitSequence(DataParser.SequenceContext ctx) {
        System.out.println("exitSequence: " + ctx.getText());
    }

    @Override
    public void visitTerminal(TerminalNode node) {

    }

    @Override
    public void visitErrorNode(ErrorNode node) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {

    }
}
