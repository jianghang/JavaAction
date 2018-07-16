package com.hangjiang.errors.call;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    public static void main(String[] args) {
        String f = "f((34);";
        CharStream charStream = CharStreams.fromString(f);
        CallLexer lexer = new CallLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        CallParser callParser = new CallParser(tokenStream);
        callParser.stat();
    }
}
