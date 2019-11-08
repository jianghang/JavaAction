package com.hangjiang.gen.tour;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class InsertAnnotationMain {
    public static void main(String[] args) {
        String code = "package com.sunsharing.opendata.web.service.sso;\n" +
                "\n" +
                "import com.sunsharing.opendata.web.model.sso.UserView;\n" +
                "\n" +
                "public interface UserService {\n" +
                "\n" +
                "    UserView saveUserInfo(UserView userView);\n" +
                "}";
        System.out.println(generatorInsertAnnotation(code));
    }

    public static String generatorInsertAnnotation(String code) {
        CharStream charStream = CharStreams.fromString(code);
        JavaLexer javaLexer = new JavaLexer(charStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(javaLexer);

        JavaParser javaParser = new JavaParser(commonTokenStream);
        ParseTree parseTree = javaParser.compilationUnit();

        ParseTreeWalker walker = new ParseTreeWalker();
//        InsertSerialIDListener insertSerialIDListener = new InsertSerialIDListener(commonTokenStream);
        InsertAnnotationListener insertAnnotationListener = new InsertAnnotationListener(commonTokenStream);
        walker.walk(insertAnnotationListener, parseTree);

//        System.out.println(insertAnnotationListener.rewriter.getText());
        return insertAnnotationListener.rewriter.getText();
    }
}
