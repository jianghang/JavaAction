package com.hangjiang.lexmagic.xmlparser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class XMLParserMain {

    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<Root>\n" +
                "    <Status>00</Status>\n" +
                "    <ErrorMsg>正常</ErrorMsg>\n" +
                "    <Data>\n" +
                "        <Row>\n" +
                "            <Item col=\"XM\">杨谨鸿</Item>\n" +
                "            <Item col=\"SFZH\">350681200909132011</Item>\n" +
                "            <Item col=\"CYM\"></Item>\n" +
                "            <Item col=\"MZ\">汉族</Item>\n" +
                "            <Item col=\"CSRQ\">20090913</Item>\n" +
                "            <Item col=\"XB\">男</Item>\n" +
                "            <Item col=\"WHCD\"></Item>\n" +
                "            <Item col=\"ZZ\"></Item>\n" +
                "            <Item col=\"ZZSSXQ\"></Item>\n" +
                "            <Item col=\"QTZZXZ\"></Item>\n" +
                "            <Item col=\"CSD\"></Item>\n" +
                "            <Item col=\"HYZK\"></Item>\n" +
                "            <Item col=\"SG\"></Item>\n" +
                "            <Item col=\"ZY\"></Item>\n" +
                "            <Item col=\"FWCS\"></Item>\n" +
                "            <Item col=\"BDRQ\"></Item>\n" +
                "            <Item col=\"BDYY\"></Item>\n" +
                "            <Item col=\"HDRQ\"></Item>\n" +
                "            <Item col=\"RYBH\"></Item>\n" +
                "            <Item col=\"HKSZD\">白水镇金鳌村和埔34号</Item>\n" +
                "            <Item col=\"CSDXZ\"></Item>\n" +
                "            <Item col=\"JGSSX\">福建省龙海市</Item>\n" +
                "            <Item col=\"JGGJ\"></Item>\n" +
                "            <Item col=\"BYQK\"></Item>\n" +
                "            <Item col=\"CSDGJ\"></Item>\n" +
                "            <Item col=\"XP\"></Item>\n" +
                "            <Item col=\"ZZXZ\"></Item>\n" +
                "            <Item col=\"QTZZSSXQ\"></Item>\n" +
                "        </Row>\n" +
                "        <Row>\n" +
                "            <Item col=\"XM\">杨谨鸿</Item>\n" +
                "            <Item col=\"SFZH\">350681200909132011</Item>\n" +
                "            <Item col=\"CYM\"></Item>\n" +
                "            <Item col=\"MZ\"></Item>\n" +
                "            <Item col=\"CSRQ\">20090913</Item>\n" +
                "            <Item col=\"XB\">女</Item>\n" +
                "            <Item col=\"WHCD\"></Item>\n" +
                "            <Item col=\"ZZ\"></Item>\n" +
                "            <Item col=\"ZZSSXQ\"></Item>\n" +
                "            <Item col=\"QTZZXZ\"></Item>\n" +
                "            <Item col=\"CSD\"></Item>\n" +
                "            <Item col=\"HYZK\"></Item>\n" +
                "            <Item col=\"SG\"></Item>\n" +
                "            <Item col=\"ZY\"></Item>\n" +
                "            <Item col=\"FWCS\"></Item>\n" +
                "            <Item col=\"BDRQ\"></Item>\n" +
                "            <Item col=\"BDYY\"></Item>\n" +
                "            <Item col=\"HDRQ\"></Item>\n" +
                "            <Item col=\"RYBH\"></Item>\n" +
                "            <Item col=\"HKSZD\"></Item>\n" +
                "            <Item col=\"CSDXZ\"></Item>\n" +
                "            <Item col=\"JGSSX\"></Item>\n" +
                "            <Item col=\"JGGJ\"></Item>\n" +
                "            <Item col=\"BYQK\"></Item>\n" +
                "            <Item col=\"CSDGJ\"></Item>\n" +
                "            <Item col=\"XP\"></Item>\n" +
                "            <Item col=\"ZZXZ\"></Item>\n" +
                "            <Item col=\"QTZZSSXQ\"></Item>\n" +
                "        </Row>\n" +
                "    </Data>\n" +
                "</Root>";
        CharStream charStream = CharStreams.fromString(xml);
        XMLLexer xmlLexer = new XMLLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(xmlLexer);

        XMLParser xmlParser = new XMLParser(tokenStream);
        ParseTree tree = xmlParser.document();

        MyXMLParserListener xmlParserListener = new MyXMLParserListener();
//        MyXMLParserVisitor xmlParserVisitor = new MyXMLParserVisitor();
//        String content = xmlParserVisitor.visit(tree);
//        System.out.println(content);

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(xmlParserListener,tree);
    }
}
