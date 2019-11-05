package com.hangjiang.gen.tour;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

/**
 * Created by jianghang on 2018/3/29.
 */
public class InsertSerialIDListener extends JavaBaseListener {

    protected TokenStreamRewriter rewriter;

    public InsertSerialIDListener(TokenStream tokenStream) {
        rewriter = new TokenStreamRewriter(tokenStream);
    }

    @Override
    public void enterClassBody(JavaParser.ClassBodyContext ctx) {
        String field = "\n\tpublic static final long serialVersionUID = 1L;";
        rewriter.insertAfter(ctx.start, field);
    }

    @Override
    public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
        String str = "@PostMapping(\"/" + ctx.Identifier() + "\"" + ")\n";
        rewriter.insertBefore(ctx.start, str);
    }
}
