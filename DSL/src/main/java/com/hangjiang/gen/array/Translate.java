package com.hangjiang.gen.array;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;

/**
 * Created by jianghang on 2018/1/23.
 */
public class Translate {

    public static void main(String[] args) throws IOException {
        String str = "{1,3,5}";
        ANTLRInputStream inputStream = new ANTLRInputStream(str);
        ArrayInitLexer lexer = new ArrayInitLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ArrayInitParser parser = new ArrayInitParser(tokenStream);

        ParseTree tree = parser.init();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ShortToUnicodeString(),tree);
        System.out.println();
    }
}
