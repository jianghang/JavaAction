package com.hangjiang.gen.expr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jianghang on 2018/1/23.
 */
public class ExprJoyRide {

    public static void main(String[] args) throws IOException {
        String path = ExprJoyRide.class.getResource("/").getPath();
        System.out.println(path);
        InputStream inputStream = new FileInputStream(path + "t.expr");
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(inputStream);
        ExprLexer lexer = new ExprLexer(antlrInputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokenStream);
        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }
}
