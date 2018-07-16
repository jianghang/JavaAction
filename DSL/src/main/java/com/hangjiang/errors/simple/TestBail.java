package com.hangjiang.errors.simple;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.LexerNoViableAltException;

public class TestBail {

    public static class BailSimpleLexer extends SimpleLexer{

        public BailSimpleLexer(CharStream input) {
            super(input);
        }

        @Override
        public void recover(LexerNoViableAltException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String code = "class { int t;}";
        CharStream charStream = CharStreams.fromString(code);
        BailSimpleLexer lexer = new BailSimpleLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        SimpleParser simpleParser = new SimpleParser(tokenStream);
        simpleParser.setErrorHandler(new BailErrorStrategy());
        simpleParser.prog();
    }
}
