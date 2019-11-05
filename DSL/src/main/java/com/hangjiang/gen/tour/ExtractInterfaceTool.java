package com.hangjiang.gen.tour;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * Created by jianghang on 2018/3/22.
 */
public class ExtractInterfaceTool {

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
//        ANTLRInputStream inputStream = new ANTLRInputStream(code);
        CharStream charStream = CharStreams.fromString(code);
        JavaLexer javaLexer = new JavaLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(javaLexer);

        JavaParser javaParser = new JavaParser(tokenStream);
        ParseTree tree = javaParser.compilationUnit();

        ParseTreeWalker walker = new ParseTreeWalker();
        ExtractInterfaceListener extractInterfaceListener = new ExtractInterfaceListener(javaParser);

        walker.walk(extractInterfaceListener, tree);
    }
}
