package com.hangjiang.listeners.cymbol;

import com.hangjiang.listeners.cymbol.symboltable.Symbol;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class CheckSymbols {

    public static Symbol.Type getType(int tokenType){
        switch (tokenType){
            case CymbolParser.K_VOID : return Symbol.Type.tVOID;
            case CymbolParser.K_INT : return Symbol.Type.tINT;
            case CymbolParser.K_FLOAT : return Symbol.Type.tFLOAT;
        }

        return Symbol.Type.tINVALID;
    }

    public static void error(Token token,String msg){
        System.err.printf("line %d:%d %s\n",token.getLine(),token.getCharPositionInLine(),msg);
    }

    public static void main(String[] args) {
        String code = "int f(int x, float y) {\n" +
                "    g();   // forward reference is ok\n" +
                "    i = 3; // no declaration for i (error)\n" +
                "    g = 4; // g is not variable (error)\n" +
                "    return x + y; // x, y are defined, so no problem\n" +
                "}\n" +
                "\n" +
                "void g() {\n" +
                "    int x = 0;\n" +
                "    float y;\n" +
                "    y = 9; // y is defined\n" +
                "    f();   // backward reference is ok\n" +
                "    z();   // no such function (error)\n" +
                "    y();   // y is not function (error)\n" +
                "    x = f; // f is not a variable (error)\n" +
                "}\n";
        CharStream charStream = CharStreams.fromString(code);
        CymbolLexer lexer = new CymbolLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CymbolParser parser = new CymbolParser(tokenStream);
        ParseTree parseTree = parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();
        DefPhase defPhase = new DefPhase();
        walker.walk(defPhase,parseTree);

        RefPhase refPhase = new RefPhase(defPhase.globalScope,defPhase.scopes);
        walker.walk(refPhase,parseTree);
    }
}
