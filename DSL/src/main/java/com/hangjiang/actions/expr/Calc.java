package com.hangjiang.actions.expr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Calc {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String expr = reader.readLine();
        int line = 1;

        ExprParser exprParser = new ExprParser(null);
        exprParser.setBuildParseTree(false);

        while (expr != null){
            CharStream charStream = CharStreams.fromString(expr + "\n");
            ExprLexer lexer = new ExprLexer(charStream);
            lexer.setLine(line);
            lexer.setCharPositionInLine(0);

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            exprParser.setInputStream(tokenStream);
            exprParser.stat();
            expr = reader.readLine();
            line++;
        }
    }
}
