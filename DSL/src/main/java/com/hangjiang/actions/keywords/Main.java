package com.hangjiang.actions.keywords;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    public static void main(String[] args) {
        String keyword = "if 1 then x = ;";
        CharStream charStream = CharStreams.fromString(keyword);
        KeywordsLexer lexer = new KeywordsLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        KeywordsParser parser = new KeywordsParser(tokenStream);
        parser.stat();
    }
}
