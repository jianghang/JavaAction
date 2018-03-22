package com.hangjiang.gen.tour;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jianghang on 2018/1/24.
 */
public class Calc {

    public static void main(String[] args) throws IOException {
        String path = Calc.class.getResource("/").getPath();
        System.out.println(path);
        InputStream in = new FileInputStream(path + "t.expr");
        ANTLRInputStream inputStream = new ANTLRInputStream("4+5\n");
        LabeledExprLexer lexer = new LabeledExprLexer(inputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        LabeledExprParser parser = new LabeledExprParser(tokenStream);
        ParseTree tree = parser.prog();

        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }
}
