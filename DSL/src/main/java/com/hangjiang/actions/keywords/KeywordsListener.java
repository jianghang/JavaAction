// Generated from /Users/jianghang/IdeaProjects/JavaAction/DSL/src/main/java/com/hangjiang/actions/keywords/Keywords.g4 by ANTLR 4.7
package com.hangjiang.actions.keywords;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link KeywordsParser}.
 */
public interface KeywordsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link KeywordsParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(KeywordsParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeywordsParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(KeywordsParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link KeywordsParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(KeywordsParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link KeywordsParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(KeywordsParser.ExprContext ctx);
}