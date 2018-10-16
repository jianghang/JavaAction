package com.hangjiang.lexmagic.xmlparser;

public class MyXMLParserListener extends XMLParserBaseListener{

    @Override
    public void exitContent(XMLParser.ContentContext ctx) {
//        System.out.println(ctx.getText());
    }

    @Override
    public void enterElement(XMLParser.ElementContext ctx) {
        System.out.println(ctx.Name(0));
    }

    @Override
    public void exitElement(XMLParser.ElementContext ctx) {
//        System.out.println(ctx.getText());
//        System.out.println(ctx.Name(0));
    }

    @Override
    public void exitAttribute(XMLParser.AttributeContext ctx) {
        System.out.println(ctx.Name().getText() + " : " + ctx.STRING().getText());
    }
}
