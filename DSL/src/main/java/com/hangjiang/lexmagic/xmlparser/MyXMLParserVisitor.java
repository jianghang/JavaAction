package com.hangjiang.lexmagic.xmlparser;

public class MyXMLParserVisitor extends XMLParserBaseVisitor<String>{
    @Override
    public String visitContent(XMLParser.ContentContext ctx) {
        return ctx.getText();
    }
}
