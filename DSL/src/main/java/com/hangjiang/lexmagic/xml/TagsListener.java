// Generated from /Users/jianghang/IdeaProjects/JavaAction/DSL/src/main/java/com/hangjiang/lexmagic/xml/Tags.g4 by ANTLR 4.7
package com.hangjiang.lexmagic.xml;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TagsParser}.
 */
public interface TagsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TagsParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(TagsParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TagsParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(TagsParser.FileContext ctx);
}