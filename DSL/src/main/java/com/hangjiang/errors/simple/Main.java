package com.hangjiang.errors.simple;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Collections;
import java.util.List;

public class Main {

    public static class VerboseListener extends BaseErrorListener{
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
            Collections.reverse(stack);

            System.err.println("rule stack: " + stack);
            System.err.println("line " + line + ":" + charPositionInLine + " at " + offendingSymbol + " : " + msg);
        }
    }

    public static class UnderlineListener extends BaseErrorListener{
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
            System.err.println("line " + line + " : " + charPositionInLine + " " + msg);
            underlineError(recognizer,(Token)offendingSymbol,line,charPositionInLine);
        }

        private void underlineError(Recognizer<?, ?> recognizer, Token offendingSymbol, int line, int charPositionInLine) {
            CommonTokenStream tokenStream = (CommonTokenStream)recognizer.getInputStream();
            String input = tokenStream.getTokenSource().getInputStream().toString();

            String[] lines = input.split("\n");
            String errorLine = lines[line - 1];
            System.err.println(errorLine);
            for(int i = 0;i < charPositionInLine; i++){
                System.err.print(" ");
            }
            int start = offendingSymbol.getStartIndex();
            int stop = offendingSymbol.getStopIndex();
            if(start >= 0 && stop >= 0){
                for(int j = start; j <= stop; j++){
                    System.err.print("^");
                }
            }
            System.err.println();
        }
    }

    public static void main(String[] args) {
        String code = "class # {int y(x) {a = 3 4 5;}}";

        CharStream charStream = CharStreams.fromString(code);
        SimpleLexer lexer = new SimpleLexer(charStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);

        SimpleParser parser = new SimpleParser(commonTokenStream);
        parser.removeErrorListeners();
        parser.addErrorListener(new UnderlineListener());
        ParseTree tree = parser.prog();

        SimpleBaseListener listener = new SimpleBaseListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener,tree);
    }
}
