package com.hangjiang.recursive_descert.multi;

import com.hangjiang.lexer.Lexer;
import com.hangjiang.lexer.ListLexer;

/**
 * Created by jianghang on 2018/1/28.
 */
public class LookaheadParser extends Parser{

    public LookaheadParser(Lexer input, int k) {
        super(input, k);
    }

    // element : NAME '=' NAME | NAME | list ;
    public void element(){
        if(LA(1) == ListLexer.NAME && LA(2) == ListLexer.EQUALS){
            match(ListLexer.NAME);
            match(ListLexer.EQUALS);
            match(ListLexer.NAME);
        }else if(LA(1) == ListLexer.NAME){
            match(ListLexer.NAME);
        }else if(LA(1) == ListLexer.LBRACK){
            list();
        }else {
            throw new Error("expecting name or list: found " + LT(1));
        }
    }

    // list : '[' elements ']' ;
    public void list(){
        match(ListLexer.LBRACK);
        elements();
        match(ListLexer.RBRACK);
    }

    // elements : element (',' element)* ;
    private void elements() {
        element();
        while (LA(1) == ListLexer.COMMA){
            match(ListLexer.COMMA);
            element();
        }
    }
}
