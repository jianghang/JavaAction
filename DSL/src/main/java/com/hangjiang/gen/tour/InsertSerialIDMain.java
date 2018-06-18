package com.hangjiang.gen.tour;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Created by jianghang on 2018/3/29.
 */
public class InsertSerialIDMain {
    public static void main(String[] args) {
        String code = "package com.hangjiang.gen.tour;\n" +
                "\n" +
                "import java.util.List;\n" +
                "import java.util.Map;\n" +
                "\n" +
                "/**\n" +
                " * Created by jianghang on 2018/3/22.\n" +
                " */\n" +
                "public class Demo {\n" +
                "    void f(int x,String y){};\n" +
                "    int[] g(/*no args*/){return null;}\n" +
                "    List<Map<String,Integer>>[] h() {return null;}\n" +
                "}\n";
        ANTLRInputStream antlrInputStream = new ANTLRInputStream(code);
        JavaLexer javaLexer = new JavaLexer(antlrInputStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(javaLexer);

        JavaParser javaParser = new JavaParser(commonTokenStream);
        ParseTree parseTree = javaParser.compilationUnit();

        ParseTreeWalker walker = new ParseTreeWalker();
        InsertSerialIDListener insertSerialIDListener = new InsertSerialIDListener(commonTokenStream);
        walker.walk(insertSerialIDListener,parseTree);

        System.out.println(insertSerialIDListener.rewriter.getText());
    }
}
