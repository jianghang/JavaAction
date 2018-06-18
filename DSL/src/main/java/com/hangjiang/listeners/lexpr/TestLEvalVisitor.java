package com.hangjiang.listeners.lexpr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class TestLEvalVisitor {
    public static class EvalVisitor extends LExprBaseVisitor<Integer>{
        @Override
        public Integer visitMult(LExprParser.MultContext ctx) {

            return visit(ctx.e(0)) * visit(ctx.e(1));
        }

        @Override
        public Integer visitAdd(LExprParser.AddContext ctx) {

            return visit(ctx.e(0)) + visit(ctx.e(1));
        }

        @Override
        public Integer visitInt(LExprParser.IntContext ctx) {
            return Integer.valueOf(ctx.INT().getText());
        }
    }

    public static void main(String[] args) {
        String expr = "4+5*6";

        CharStream charStream = CharStreams.fromString(expr);
        LExprLexer lexer = new LExprLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        LExprParser parser = new LExprParser(tokenStream);
        ParseTree tree = parser.s();

        EvalVisitor evalVisitor = new EvalVisitor();
        int result = evalVisitor.visit(tree);
        System.out.println(result);
    }
}
