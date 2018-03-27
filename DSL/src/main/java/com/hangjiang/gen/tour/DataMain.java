package com.hangjiang.gen.tour;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Created by jianghang on 2018/3/27.
 */
public class DataMain {

    public static void main(String[] args) {
        String str = "2 2 3 3 44 6 7";
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(str);
        DataLexer lexer = new DataLexer(antlrInputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        DataParser parser = new DataParser(tokenStream);
        ParseTree parseTree = parser.file();
        System.out.println(parseTree.toStringTree(parser));

        ParseTreeWalker walker = new ParseTreeWalker();
        ExtractDataListener dataListener = new ExtractDataListener();

        walker.walk(dataListener,parseTree);
    }
}
