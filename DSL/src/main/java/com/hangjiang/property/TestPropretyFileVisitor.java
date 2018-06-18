package com.hangjiang.property;

import org.antlr.v4.misc.OrderedHashMap;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.Map;

public class TestPropretyFileVisitor {

    public static class PropertyFileVisitor extends PropertyFileBaseVisitor<Void>{

        public Map<String,String> props = new OrderedHashMap<>();

        @Override
        public Void visitProp(PropertyFileParser.PropContext ctx) {
            String id = ctx.ID().getText();
            String value = ctx.STRING().getText();
            props.put(id,value);

            return null;
        }
    }

    public static void main(String[] args) {
        String property = "yy=\"uuunn\"";

        CharStream charStream = CharStreams.fromString(property);
        PropertyFileLexer lexer = new PropertyFileLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        PropertyFileParser parser = new PropertyFileParser(tokenStream);

        ParseTree parseTree = parser.file();

        PropertyFileVisitor visitor = new PropertyFileVisitor();
        visitor.visit(parseTree);

        System.out.println(visitor.props);
    }
}
