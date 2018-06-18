package com.hangjiang.gen.tour;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 * Created by jianghang on 2018/3/29.
 */
public class XMLMain {
    public static void main(String[] args) {
        String xml = "<!--\n" +
                " ! Excerpted from \"The Definitive ANTLR 4 Reference\",\n" +
                " ! published by The Pragmatic Bookshelf.\n" +
                " ! Copyrights apply to this code. It may not be used to create training material, \n" +
                " ! courses, books, articles, and the like. Contact us if you are in doubt.\n" +
                " ! We make no guarantees that this code is fit for any purpose. \n" +
                " ! Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.\n" +
                "-->\n" +
                "<tools>\n" +
                "\t<tool name=\"ANTLR\">A parser generator</tool>\n" +
                "</tools>";
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(xml);
        XMLLexer xmlLexer = new XMLLexer(antlrInputStream);
        CommonTokenStream tokenStream = new CommonTokenStream(xmlLexer);
        System.out.println(tokenStream.getTokens().toString());
    }
}
