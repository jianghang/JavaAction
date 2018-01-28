package com.hangjiang.recursive_descert;

import com.hangjiang.lexer.Lexer;
import com.hangjiang.lexer.ListLexer;

/**
 * Created by jianghang on 2018/1/28.
 */
public class ListParser extends Parser{

    public ListParser(Lexer input) {
        super(input);
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
        while (lookahead.type == ListLexer.COMMA){
            match(ListLexer.COMMA);
            element();
        }
    }

    // element : Name | list ;
    private void element() {
        if(lookahead.type == ListLexer.NAME){
            match(ListLexer.NAME);
        }else if(lookahead.type == ListLexer.LBRACK){
            list();
        }else{
            throw new Error("expecting name or list; found " + lookahead);
        }
    }
}
