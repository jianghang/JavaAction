package com.hangjiang.listeners.cymbol;

import com.hangjiang.listeners.cymbol.symboltable.*;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class RefPhase extends CymbolBaseListener{

    GlobalScope globalScope;
    ParseTreeProperty<Scope> scopes;
    Scope currentScope;

    public RefPhase(GlobalScope globalScope, ParseTreeProperty<Scope> scopes){
        this.globalScope = globalScope;
        this.scopes = scopes;
    }

    @Override
    public void enterFile(CymbolParser.FileContext ctx) {
        currentScope = globalScope;
    }

    @Override
    public void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterBlock(CymbolParser.BlockContext ctx) {
        currentScope = scopes.get(ctx);
    }

    @Override
    public void exitBlock(CymbolParser.BlockContext ctx) {
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void exitVar(CymbolParser.VarContext ctx) {
        String name = ctx.ID().getSymbol().getText();
        Symbol var = currentScope.resolve(name);
        if(var == null){
            CheckSymbols.error(ctx.ID().getSymbol(),"no such variable: " + name);
        }
        if(var instanceof FunctionSymbol){
            CheckSymbols.error(ctx.ID().getSymbol(),name + " is not a variable");
        }
    }

    @Override
    public void exitCall(CymbolParser.CallContext ctx) {
        String funcName = ctx.ID().getText();
        Symbol meth = currentScope.resolve(funcName);
        if(meth == null){
            CheckSymbols.error(ctx.ID().getSymbol(),"no such function: " + funcName);
        }
        if(meth instanceof VariableSymbol){
            CheckSymbols.error(ctx.ID().getSymbol(),funcName + " is not a function");
        }
    }
}
