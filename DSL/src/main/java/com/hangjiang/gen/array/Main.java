package com.hangjiang.gen.array;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

/**
 * Created by jianghang on 2018/1/23.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //新建一个CharStream，从标准输入读取数据
        ANTLRInputStream inputStream = new ANTLRInputStream(System.in);

        //新建一个词法分析器，处理输入的CharStream
        ArrayInitLexer lexer = new ArrayInitLexer(inputStream);

        //新建一个词法符号的缓冲区，用于存储词法分析器生成的词法符号
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        //新建一个语法分析器，处理词法符号缓冲区中的内容
        ArrayInitParser parser = new ArrayInitParser(tokenStream);

        ParseTree tree = parser.init();
        System.out.println(tree.toStringTree(parser));
    }
}
