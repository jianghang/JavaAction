package com.hangjiang.listeners.lexpr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class TestLEvaluatorWithProps {

    public static class EvalutorWithProps extends LExprBaseListener{
        ParseTreeProperty<Integer> values = new ParseTreeProperty<>();

        @Override
        public void exitInt(LExprParser.IntContext ctx) {
            String intText = ctx.INT().getText();
            setValue(ctx,Integer.valueOf(intText));
        }

        @Override
        public void exitAdd(LExprParser.AddContext ctx) {
            int left = getValue(ctx.e(0));
            int right = getValue(ctx.e(1));
            setValue(ctx,left + right);
        }

        @Override
        public void exitMult(LExprParser.MultContext ctx) {
            int left = getValue(ctx.e(0));
            int right = getValue(ctx.e(1));
            setValue(ctx,left * right);
        }

        @Override
        public void exitS(LExprParser.SContext ctx) {
            setValue(ctx,getValue(ctx.e()));
        }

        public void setValue(ParseTree node, int value){
            values.put(node,value);
        }

        public int getValue(ParseTree node){
            return values.get(node);
        }
    }

    public static void main(String[] args) {
        String expr = "4*5+9";
        CharStream charStream = CharStreams.fromString(expr);
        LExprLexer lexer = new LExprLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        LExprParser parser = new LExprParser(tokenStream);
        ParseTree tree = parser.s();

        ParseTreeWalker walker = new ParseTreeWalker();
        EvalutorWithProps evalutorWithProps = new EvalutorWithProps();
        walker.walk(evalutorWithProps,tree);

        System.out.println("properties result = " + evalutorWithProps.getValue(tree));
    }
}
