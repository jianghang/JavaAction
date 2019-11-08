package com.hangjiang.gen.tour;

import com.google.common.collect.Sets;

import java.util.Objects;
import java.util.Set;

public class GeneratorListener extends JavaBaseListener {

    private static Set<String> baseTypeSet = Sets.newHashSet("String", "int", "Integer");

    private String serviceName;

    private StringBuilder codeBuilder;

    private JavaParser javaParser;
    public static String controllerName;

    public GeneratorListener(JavaParser javaParser, StringBuilder builder) {
        this.javaParser = javaParser;
        this.codeBuilder = builder;
    }

    @Override
    public void enterPackageDeclaration(JavaParser.PackageDeclarationContext ctx) {
        String str = javaParser.getTokenStream().getText(ctx);
        str = "package com.sunsharing.opendata.web.controller;";
        codeBuilder.append(str).append("\n\n");
        String importStr = "import com.sunsharing.share.webex.annotation.ShareRest;\n" +
                "import org.springframework.beans.factory.annotation.Autowired;\n" +
                "import org.springframework.web.bind.annotation.GetMapping;\n" +
                "import org.springframework.web.bind.annotation.RequestMapping;\n" +
                "import org.springframework.web.bind.annotation.RestController;\n" +
                "import org.springframework.web.bind.annotation.RequestBody;";
        codeBuilder.append(importStr).append("\n");
//        System.out.println(str);
    }

    @Override
    public void enterImportDeclaration(JavaParser.ImportDeclarationContext ctx) {
        String str = javaParser.getTokenStream().getText(ctx);
        codeBuilder.append(str).append("\n");
//        System.out.println(str);
    }

    @Override
    public void enterNormalInterfaceDeclaration(JavaParser.NormalInterfaceDeclarationContext ctx) {
        String name = ctx.Identifier().getText();
        String controllerName = name.replaceAll("I?(.*?)Service", "$1");
        serviceName = controllerName.substring(0, 1).toLowerCase() + controllerName.substring(1) + "Service";
        controllerName = controllerName + "Controller";
        GeneratorListener.controllerName = controllerName;

        String path = name.replaceAll("I?(.*?)Service", "$1");
        path = path.substring(0, 1).toLowerCase() + path.substring(1);
        String str = "\n@RestController\n" +
                "@ShareRest\n" +
                "@RequestMapping(\"" + "rpc/" + path + "\")" +
                "\npublic class " + controllerName + " {\n\n" +
                "\t@Autowired\n" +
                "\tprivate " + name + " " + serviceName + ";\n";
        codeBuilder.append(str).append("\n");
//        System.out.println(str);
    }

    @Override
    public void enterInterfaceMethodOrFieldDecl(JavaParser.InterfaceMethodOrFieldDeclContext ctx) {
        JavaParser.ClassOrInterfaceTypeContext classOrInterfaceTypeContext = ctx.type().classOrInterfaceType();
        String returnTypeStr;
        if (Objects.isNull(classOrInterfaceTypeContext)) {
            returnTypeStr = ctx.type().primitiveType().getText();
        } else {
            returnTypeStr = ctx.type().classOrInterfaceType().getText();
        }
        String methodNameStr = ctx.Identifier().getText();

        JavaParser.FormalParametersContext formalParameterDeclsContext = ctx.interfaceMethodOrFieldRest().interfaceMethodDeclaratorRest().formalParameters();
        String fieldStr = "";
        if (Objects.isNull(formalParameterDeclsContext.formalParameterDecls())) {
            fieldStr = javaParser.getTokenStream().getText(formalParameterDeclsContext);
        } else {
            JavaParser.TypeContext typeContext = formalParameterDeclsContext.formalParameterDecls().type();
            if (Objects.isNull(typeContext.classOrInterfaceType())) {
                fieldStr = javaParser.getTokenStream().getText(formalParameterDeclsContext);
            } else {
                String varId = formalParameterDeclsContext.formalParameterDecls().formalParameterDeclsRest().variableDeclaratorId().getText();
                String typeFieldStr = javaParser.getTokenStream().getText(typeContext);
                if (baseTypeSet.contains(typeFieldStr)) {
                    fieldStr = "(" + typeFieldStr + " " + varId + ")";
                } else {
                    fieldStr = "(@RequestBody " + typeFieldStr + " " + varId + ")";
                }
            }
        }
        String callMethodNameStr = ctx.Identifier().getText();
        StringBuilder builder = new StringBuilder();
        String paramListStr = getMethodListStr(ctx.interfaceMethodOrFieldRest().interfaceMethodDeclaratorRest().formalParameters().formalParameterDecls(), builder);

        String str = "\t@RequestMapping(\"/" + methodNameStr + "\")\n" +
                "\tpublic " + returnTypeStr + " " + methodNameStr + fieldStr +
                "{\n" +
                "\t" +
                "\treturn " + serviceName + "." + callMethodNameStr + "(" + paramListStr + ")" + ";" +
                "\n\t}\n";
        codeBuilder.append(str).append("\n");
//        System.out.println(str);
    }

    private String getMethodListStr(JavaParser.FormalParameterDeclsContext formalParameterDecls, StringBuilder builder) {
        if (Objects.isNull(formalParameterDecls)) {
        } else {
            String paramStr = formalParameterDecls.formalParameterDeclsRest().variableDeclaratorId().Identifier().getText();
            builder.append(paramStr).append(",");
            getMethodListStr(formalParameterDecls.formalParameterDeclsRest().formalParameterDecls(), builder);
        }
        return builder.length() > 1 ? builder.substring(0, builder.length() - 1) : builder.toString();
    }

    @Override
    public void exitTypeDeclaration(JavaParser.TypeDeclarationContext ctx) {
        String str = "\n}";
        codeBuilder.append(str).append("\n");
//        System.out.println(str);
    }
}
