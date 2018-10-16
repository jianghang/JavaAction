package com.hangjiang.lexmagic.xml;

import org.antlr.v4.runtime.BufferedTokenStream;

public class CustomModeTagsParserListener extends ModeTagsParserBaseListener{

    private BufferedTokenStream tokenStream;

    public CustomModeTagsParserListener(BufferedTokenStream tokenStream){
        this.tokenStream = tokenStream;
    }

    @Override
    public void exitTag(ModeTagsParser.TagContext ctx) {
        System.out.println(ctx.ID().getText());
    }
}
