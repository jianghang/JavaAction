// Generated from /Users/jianghang/IdeaProjects/JavaAction/DSL/src/main/java/com/hangjiang/lexmagic/xml/ModeTagsParser.g4 by ANTLR 4.7
package com.hangjiang.lexmagic.xml;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ModeTagsParser}.
 */
public interface ModeTagsParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ModeTagsParser#file}.
	 * @param ctx the parse tree
	 */
	void enterFile(ModeTagsParser.FileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModeTagsParser#file}.
	 * @param ctx the parse tree
	 */
	void exitFile(ModeTagsParser.FileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ModeTagsParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(ModeTagsParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link ModeTagsParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(ModeTagsParser.TagContext ctx);
}