package com.hangjiang.gen.tour;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by jianghang on 2018/3/27.
 */
public class RowsMain {

    public static void main(String[] args) {
        String str = "parrt\tTerence Parr\t101\n" +
                "tombu\tTom Burns\t020\n" +
                "bke\tKevin Edgar\t008\n";
        System.out.println(str);
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(str);
        RowsLexer lexer = new RowsLexer(antlrInputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        int col = Integer.valueOf("1");
        RowsParser parser = new RowsParser(tokenStream,col);
        parser.setBuildParseTree(false);
        parser.file();
    }
}
