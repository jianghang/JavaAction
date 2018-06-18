package com.hangjiang.listeners.lexpr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Stack;

public class TestEvaluator {
    public static class Evaluator extends LExprBaseListener{
        Stack<Integer> stack = new Stack<>();

        @Override
        public void exitMult(LExprParser.MultContext ctx) {
            int right = stack.pop();
            int left = stack.pop();
            stack.push(left * right);
        }

        @Override
        public void exitAdd(LExprParser.AddContext ctx) {
            int right = stack.pop();
            int left = stack.pop();
            stack.push(left + right);
        }

        @Override
        public void exitInt(LExprParser.IntContext ctx) {
            stack.push(Integer.valueOf(ctx.INT().getText()));
        }
    }

    public static void main(String[] args) {
        String expr = "4*6+3";
        CharStream charStream = CharStreams.fromString(expr);
        LExprLexer lexer = new LExprLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        LExprParser parser = new LExprParser(tokenStream);
        ParseTree parseTree = parser.s();
        ParseTreeWalker walker = new ParseTreeWalker();

        Evaluator evaluator = new Evaluator();
        walker.walk(evaluator,parseTree);

        System.out.println(evaluator.stack.pop());
    }
}
