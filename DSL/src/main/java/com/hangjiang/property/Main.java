package com.hangjiang.property;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        String property = "yy=\"uuu\"";

        String path = Main.class.getResource("/").getPath();
        InputStream in = new FileInputStream(path + "t.properties");
        CodePointCharStream codePointCharStream = CharStreams.fromString(property);
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(in);

        PropertyFileLexer lexer = new PropertyFileLexer(codePointCharStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
//        PropertyFilePrinter filePrinter = new PropertyFilePrinter(tokenStream);
//        filePrinter.file();

        System.out.println("=============================");
        PropertyFileParser propertyFileParser = new PropertyFileParser(tokenStream);
        ParseTree parseTree = propertyFileParser.file();

        PropertyFileLoader propertyFileLoader = new PropertyFileLoader();
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        parseTreeWalker.walk(propertyFileLoader,parseTree);

        System.out.println(propertyFileLoader.props);
    }
}
