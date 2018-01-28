package com.hangjiang.lexer;

/**
 * Created by jianghang on 2018/1/28.
 */
public class ListLexer extends Lexer{
    public static int NAME = 2;
    public static int COMMA = 3;
    public static int LBRACK = 4;
    public static int RBRACK = 5;
    public static int EQUALS = 6;
    public static String[] tokenNames = {"n/a","<EOF>","NAME","COMMA","LBRACK","RBRACK","EQUALS"};

    public ListLexer(String input) {
        super(input);
    }

    protected boolean isLETTER(){
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    @Override
    public Token nextToken() {
        while (c != EOF){
            switch (c){
                case ' ' :
                case '\t' :
                case '\n' :
                case '\r' : WS(); continue;
                case ',' : consume(); return new Token(COMMA,",");
                case '[' : consume(); return new Token(LBRACK,"[");
                case ']' : consume(); return new Token(RBRACK,"]");
                case '=' : consume(); return new Token(EQUALS,"=");
                default:
                    if(isLETTER()){
                        return NAME();
                    }
                    throw new Error("invalid character: " + c);
            }
        }

        return new Token(EOF_TYPE,"<EOF>");
    }

    //NAME : ('a'..'z' | 'A'..'Z')+
    private Token NAME() {
        StringBuilder builder = new StringBuilder();
        do{
            builder.append(c);
            consume();
        }while (isLETTER());

        return new Token(NAME,builder.toString());
    }

    //WS : (' ' | '\t' | '\n' | '\r')*
    private void WS() {
        while (c == ' ' || c == '\t' || c == '\n' || c == '\r'){
            consume();
        }
    }

    @Override
    public String getTokenName(int tokenType) {
        return tokenNames[tokenType];
    }
}
