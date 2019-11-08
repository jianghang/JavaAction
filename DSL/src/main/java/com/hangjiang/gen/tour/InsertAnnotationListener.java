package com.hangjiang.gen.tour;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class InsertAnnotationListener extends JavaBaseListener {

    private static Set<String> baseTypeSet = Sets.newHashSet("String", "int", "Integer");

    private Map<String, Boolean> methodMap = Maps.newHashMap();

    protected TokenStreamRewriter rewriter;

    public InsertAnnotationListener(TokenStream tokenStream) {
        rewriter = new TokenStreamRewriter(tokenStream);
    }

    @Override
    public void exitCompilationUnit(JavaParser.CompilationUnitContext ctx) {
        if (methodMap.containsValue(true)) {
            String str = "\nimport com.sunsharing.share.webex.ShareClientConstant;"
                    + "\nimport feign.Headers;";
            rewriter.insertAfter(ctx.packageDeclaration().stop, str);
        }
    }

    @Override
    public void enterPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
        String str = "\n\nimport com.sunsharing.share.webex.annotation.ShareRestClient;" +
                "\nimport feign.RequestLine;" +
                "\nimport feign.Param;";
        rewriter.insertAfter(ctx.stop, str);
    }

    @Override
    public void exitPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {

    }

    @Override
    public void enterTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {
        String path = ctx.interfaceDeclaration().normalInterfaceDeclaration().Identifier().getText();
        path = path.replaceAll("I?(.*?)Service", "$1");
        path = path.substring(0, 1).toLowerCase() + path.substring(1);
        String str = "@ShareRestClient(serverId = \"xshare\", path=\"rpc/" + path + "\", standard = true)\n";
        rewriter.insertBefore(ctx.start, str);
    }

    @Override
    public void enterInterfaceMethodOrFieldDecl(JavaParser.InterfaceMethodOrFieldDeclContext ctx) {
        String str = "@RequestLine(\"POST /" + ctx.Identifier() + "\"" + ")\n";
        rewriter.insertBefore(ctx.start, str);
    }

    @Override
    public void exitInterfaceMethodOrFieldDecl(JavaParser.InterfaceMethodOrFieldDeclContext ctx) {
        Boolean result = methodMap.get(ctx.Identifier().getText());
        if (Objects.nonNull(result) && result) {
            String str = "@Headers(ShareClientConstant.HEADER_JSON)\n";
            rewriter.insertBefore(ctx.start, str);
        }
    }

    @Override
    public void enterVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {
//        System.out.println(ctx.Identifier());
    }

    @Override
    public void enterClassOrInterfaceType(JavaParser.ClassOrInterfaceTypeContext ctx) {
//        System.out.println(ctx.Identifier());
    }

    @Override
    public void enterFormalParameterDecls(JavaParser.FormalParameterDeclsContext ctx) {
        JavaParser.ClassOrInterfaceTypeContext classOrInterfaceTypeContext = ctx.type().classOrInterfaceType();
        if(Objects.isNull(classOrInterfaceTypeContext)){
            String str = ctx.type().primitiveType().getText();
            if (baseTypeSet.contains(str)) {
                String paramStr = ctx.formalParameterDeclsRest().variableDeclaratorId().Identifier().getText();
                String codeStr = "@Param(\"" + paramStr + "\") ";
                rewriter.insertBefore(ctx.type().primitiveType().start, codeStr);
            }
        }else {
            String str = ctx.type().classOrInterfaceType().Identifier().get(0).getText();
            if (baseTypeSet.contains(str)) {
                String paramStr = ctx.formalParameterDeclsRest().variableDeclaratorId().Identifier().getText();
                String codeStr = "@Param(\"" + paramStr + "\") ";
                rewriter.insertBefore(ctx.type().classOrInterfaceType().start, codeStr);
            } else {
                String method = getMethod(ctx);
                methodMap.put(method, true);
            }
        }
//        System.out.println(str);
    }

    private String getMethod(RuleContext ctx) {
        if (ctx instanceof JavaParser.InterfaceMethodOrFieldDeclContext) {
            JavaParser.InterfaceMethodOrFieldDeclContext context = (JavaParser.InterfaceMethodOrFieldDeclContext) ctx;
            return context.Identifier().getText();
        } else {
            return getMethod(ctx.parent);
        }
    }

    @Override
    public void enterPrimitiveType(JavaParser.PrimitiveTypeContext ctx) {
//        System.out.println(ctx.getText());
    }
}
