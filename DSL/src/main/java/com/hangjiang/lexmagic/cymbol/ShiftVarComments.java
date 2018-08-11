package com.hangjiang.lexmagic.cymbol;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.List;

public class ShiftVarComments {

    public static class CommentShifter extends CymbolParserBaseListener{

        BufferedTokenStream tokens;
        TokenStreamRewriter rewriter;

        public CommentShifter(BufferedTokenStream tokens){
            this.tokens = tokens;
            rewriter = new TokenStreamRewriter(tokens);
        }

        @Override
        public void exitVarDecl(CymbolParser.VarDeclContext ctx) {
            Token semi = ctx.getStop();
            int i = semi.getTokenIndex();
            List<Token> cmtChannel = tokens.getHiddenTokensToRight(i,CymbolLexer.COMMENTS);
            if(cmtChannel != null){
                Token cmt = cmtChannel.get(0);
                if(cmt != null){
                    String txt = cmt.getText().substring(2);
                    String newCmt = "/* " + txt.trim() + " */\n";
                    rewriter.insertBefore(ctx.start,newCmt);
                    rewriter.replace(cmt,"\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        String code = "int n = 0;//定义一个计数器\n" +
                "int i = 9;";

        CharStream charStream = CharStreams.fromString(code);
        CymbolLexer lexer = new CymbolLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        CymbolParser parser = new CymbolParser(tokenStream);
        RuleContext tree = parser.file();

        ParseTreeWalker walker = new ParseTreeWalker();
        CommentShifter shifter = new CommentShifter(tokenStream);
        walker.walk(shifter,tree);

        System.out.println(shifter.rewriter.getText());
    }
}
