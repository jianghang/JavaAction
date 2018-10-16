package com.hangjiang.lexmagic.xml;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class TagsMain {

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!--\n" +
                " ! Excerpted from \"The Definitive ANTLR 4 Reference\",\n" +
                " ! published by The Pragmatic Bookshelf.\n" +
                " ! Copyrights apply to this code. It may not be used to create training material, \n" +
                " ! courses, books, articles, and the like. Contact us if you are in doubt.\n" +
                " ! We make no guarantees that this code is fit for any purpose. \n" +
                " ! Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.\n" +
                "-->\n" +
                "<?do not care?>\n" +
                "<CATALOG>\n" +
                "<PLANT id=\"45\">Orchid</PLANT>\n" +
                "</CATALOG>\n";

        CharStream charStream = CharStreams.fromString(xml);
        TagsLexer tagsLexer = new TagsLexer(charStream);

        Token token = tagsLexer.nextToken();
        while (token != null){
            System.out.println(token);
            token = tagsLexer.nextToken();
        }
    }
}
