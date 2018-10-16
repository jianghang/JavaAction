package com.hangjiang.lexmagic.xml;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ModeTagsMain {
    public static void main(String[] args) {
        String xml = "<PLANT>Orchid</PLANT>";
        CharStream charStream = CharStreams.fromString(xml);
        ModeTagsLexer lexer = new ModeTagsLexer(charStream);

        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ModeTagsParser parser = new ModeTagsParser(tokenStream);
        ParseTree tree = parser.file();

        CustomModeTagsParserListener parserListener = new CustomModeTagsParserListener(tokenStream);

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(parserListener,tree);
    }
}
