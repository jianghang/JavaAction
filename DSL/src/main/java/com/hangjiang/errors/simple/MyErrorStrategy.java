package com.hangjiang.errors.simple;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;

public class MyErrorStrategy extends DefaultErrorStrategy {
    @Override
    protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
        String msg = "can't choose between alternatives";
        recognizer.notifyErrorListeners(e.getOffendingToken(), msg, e);
    }
}
