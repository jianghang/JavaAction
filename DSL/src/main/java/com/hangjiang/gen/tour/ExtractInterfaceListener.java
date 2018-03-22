package com.hangjiang.gen.tour;

import org.antlr.v4.runtime.TokenStream;

/**
 * Created by jianghang on 2018/3/22.
 */
public class ExtractInterfaceListener extends JavaBaseListener{

    private JavaParser javaParser;

    public ExtractInterfaceListener(JavaParser javaParser){
        this.javaParser = javaParser;
    }

    @Override
    public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
        System.out.println(javaParser.getTokenStream().getText(ctx));
    }

    @Override
    public void enterClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        System.out.println("interface I" + ctx.Identifier() + " {");
    }

    @Override
    public void exitClassDeclaration(JavaParser.ClassDeclarationContext ctx) {
        System.out.println("}");
    }

    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        TokenStream tokenStream = javaParser.getTokenStream();
        String type = "void";
        if(ctx.type() != null){
            type = tokenStream.getText(ctx.type());
        }
        String args = tokenStream.getText(ctx.formalParameters());
        System.out.println("\t" + type + " " + ctx.Identifier() + args + ";");
    }
}
