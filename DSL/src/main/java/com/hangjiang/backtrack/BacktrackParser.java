package com.hangjiang.backtrack;

import com.hangjiang.lexer.Lexer;
import com.hangjiang.lexer.ListLexer;

/**
 * Created by jianghang on 2018/1/31.
 */
public class BacktrackParser extends Parser{

    public BacktrackParser(Lexer input) {
        super(input);
    }

    public void stat() throws MismatchedTokenException {
        if(speculate_stat_alt1()) {
            list();
            match(Lexer.EOF_TYPE);
        }else if(speculate_stat_alt2()){
            assign();
            match(Lexer.EOF_TYPE);
        }else {
            throw new MismatchedTokenException("expecting stat found " + LT(1));
        }
    }

    public boolean speculate_stat_alt1(){
        boolean success = true;
        mark();
        try {
            list();
            match(Lexer.EOF_TYPE);
        } catch (MismatchedTokenException e) {
            success = false;
            release();
            e.printStackTrace();
        }

        return success;
    }

    public boolean speculate_stat_alt2(){
        boolean success = true;
        mark();
        try {
            assign();
            match(Lexer.EOF_TYPE);
        } catch (MismatchedTokenException e) {
            success = false;
            e.printStackTrace();
        }
        release();

        return success;
    }

    public void assign() throws MismatchedTokenException {
        list();
        match(ListLexer.EQUALS);
        list();
    }

    // list : '[' elements ']' ;
    public void list() throws MismatchedTokenException {
        match(ListLexer.LBRACK);
        elements();
        match(ListLexer.RBRACK);
    }

    // elements : element (',' element)* ;
    private void elements() throws MismatchedTokenException {
        element();
        while (LA(1) == ListLexer.COMMA){
            match(ListLexer.COMMA);
            element();
        }
    }

    // element : NAME '=' NAME | NAME | list ;
    public void element() throws MismatchedTokenException {
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
}
