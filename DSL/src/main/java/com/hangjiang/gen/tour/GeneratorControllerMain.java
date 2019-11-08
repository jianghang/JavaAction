package com.hangjiang.gen.tour;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GeneratorControllerMain {
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\SunSharing_SourceCode\\opendata_parent\\opendata-common\\src\\main\\java\\com\\sunsharing\\opendata\\web\\service\\sso\\UserService.java");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();
        String tempStr;
        while ((tempStr = reader.readLine()) != null) {
            builder.append(tempStr);
        }
        reader.close();

        String code = generatorController(builder.toString());
        System.out.println(code);
        file = new File("F:\\SunSharing_SourceCode\\opendata_parent\\opendata-web-server\\src\\main\\java\\com\\sunsharing\\opendata\\web\\controller\\" + GeneratorListener.controllerName + ".java");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(code);
        bufferedWriter.flush();
        bufferedWriter.close();
        fileWriter.close();
    }

    public static String generatorController(String code) {
        CharStream charStream = CharStreams.fromString(code);
        JavaLexer javaLexer = new JavaLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(javaLexer);

        JavaParser javaParser = new JavaParser(tokenStream);
        ParseTree tree = javaParser.compilationUnit();

        ParseTreeWalker walker = new ParseTreeWalker();
        StringBuilder builder = new StringBuilder();
        GeneratorListener generatorListener = new GeneratorListener(javaParser, builder);

        walker.walk(generatorListener, tree);
        return builder.toString();
    }
}
