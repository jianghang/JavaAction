package com.hangjiang.lexmagic.idkeyword;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    public static void main(String[] args) {
        String id = "if if then call call;";
        CharStream charStream = CharStreams.fromString(id);
        IDKeywordLexer lexer = new IDKeywordLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        IDKeywordParser parser = new IDKeywordParser(tokenStream);
        parser.prog();
    }
}
