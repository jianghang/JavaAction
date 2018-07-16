package com.hangjiang.listeners.cymbol;

import com.hangjiang.listeners.cymbol.symboltable.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class DefPhase extends CymbolBaseListener{
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<>();
    GlobalScope globalScope;
    Scope currentScope;

    @Override
    public void enterFile(CymbolParser.FileContext ctx) {
        globalScope = new GlobalScope(null);
        currentScope = globalScope;
    }

    @Override
    public void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
        String name = ctx.ID().getText();
        int typeTokenType = ctx.type().start.getType();
        Symbol.Type type = CheckSymbols.getType(typeTokenType);

        FunctionSymbol functionSymbol = new FunctionSymbol(name,type,currentScope);
        currentScope.define(functionSymbol);
        saveScope(ctx,functionSymbol);
        currentScope = functionSymbol;
    }

    private void saveScope(ParserRuleContext ctx, Scope scope) {
        scopes.put(ctx,scope);
    }

    @Override
    public void enterBlock(CymbolParser.BlockContext ctx) {
        LocalScope localScope = new LocalScope(currentScope);
        saveScope(ctx,localScope);
        currentScope = localScope;
    }

    @Override
    public void exitFormalParameter(CymbolParser.FormalParameterContext ctx) {
        defineVar(ctx.type(),ctx.ID().getSymbol());

    }

    @Override
    public void exitVarDecl(CymbolParser.VarDeclContext ctx) {
        defineVar(ctx.type(),ctx.ID().getSymbol());
    }

    private void defineVar(CymbolParser.TypeContext typeContext, Token nameToken){
        int typeTokenType = typeContext.start.getType();
        Symbol.Type type = CheckSymbols.getType(typeTokenType);
        VariableSymbol variableSymbol = new VariableSymbol(nameToken.getText(),type);
        currentScope.define(variableSymbol);
    }

    @Override
    public void exitBlock(CymbolParser.BlockContext ctx) {
        System.out.println(currentScope);
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
        System.out.println(currentScope);
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitFile(CymbolParser.FileContext ctx) {
        System.out.println(globalScope);
    }
}
