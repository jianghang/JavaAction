package com.hangjiang.predicates;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class TestEnum {

    public static void main(String[] args) {
        String code = "enum = 8;";
        CharStream charStream = CharStreams.fromString(code);
        EnumLexer lexer = new EnumLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        EnumParser.java5 = false;
        EnumParser parser = new EnumParser(tokenStream);
        parser.prog();
    }
}
