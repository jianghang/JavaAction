package com.hangjiang.listeners.json;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class JSON2XML {

    public static class XMLEmitter extends JSONBaseListener {
        ParseTreeProperty<String> xml = new ParseTreeProperty<>();

        public String getXML(ParseTree ctx) {
            return xml.get(ctx);
        }

        public void setXML(ParseTree ctx, String s) {
            xml.put(ctx, s);
        }

        @Override
        public void exitAtom(JSONParser.AtomContext ctx) {
            setXML(ctx, ctx.getText());
        }

        @Override
        public void exitString(JSONParser.StringContext ctx) {
            setXML(ctx, stringQuotes(ctx.getText()));
        }

        @Override
        public void exitObjectValue(JSONParser.ObjectValueContext ctx) {
            setXML(ctx, getXML(ctx.object()));
        }

        @Override
        public void exitPair(JSONParser.PairContext ctx) {
            String tag = stringQuotes(ctx.STRING().getText());
            JSONParser.ValueContext valueContext = ctx.value();
            String x = String.format("<%s>%s</%s>\n", tag, getXML(valueContext), tag);
            setXML(ctx, x);
        }

        @Override
        public void exitAnObject(JSONParser.AnObjectContext ctx) {
            StringBuilder builder = new StringBuilder();
            builder.append("\n");
            for(JSONParser.PairContext pairContext : ctx.pair()){
                builder.append(getXML(pairContext));
            }
            setXML(ctx,builder.toString());
        }

        @Override
        public void exitEmptyObject(JSONParser.EmptyObjectContext ctx) {
            setXML(ctx,"");
        }

        @Override
        public void exitArrayOfValues(JSONParser.ArrayOfValuesContext ctx) {
            StringBuilder builder = new StringBuilder();

            builder.append("\n");
            ctx.value().forEach(t -> {
                builder.append("<element>");
                builder.append(getXML(t));
                builder.append("</element>");
                builder.append("\n");
            });
            setXML(ctx,builder.toString());
        }

        @Override
        public void exitArrayValue(JSONParser.ArrayValueContext ctx) {
            setXML(ctx,getXML(ctx.array()));
        }

        @Override
        public void exitEmptyArray(JSONParser.EmptyArrayContext ctx) {
            setXML(ctx,"");
        }

        @Override
        public void exitJson(JSONParser.JsonContext ctx) {
            setXML(ctx,getXML(ctx.getChild(0)));
        }

        public static String stringQuotes(String s) {
            if (s == null || s.charAt(0) != '"') return s;
            return s.substring(1, s.length() - 1);
        }
    }

    public static void main(String[] args) {
        String json = "{\n" +
                "    \"description\" : \"An imaginary server config file\",\n" +
                "    \"logs\" : {\"level\":\"verbose\", \"dir\":\"/var/log\"},\n" +
                "    \"host\" : \"antlr.org\",\n" +
                "    \"admin\": [\"parrt\", \"tombu\"],\n" +
                "    \"aliases\": []\n" +
                "}";
        CharStream charStream = CharStreams.fromString(json);
        JSONLexer jsonLexer = new JSONLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(jsonLexer);

        JSONParser jsonParser = new JSONParser(tokenStream);
        jsonParser.setBuildParseTree(true);
        ParseTree tree = jsonParser.json();

        System.out.println(tree.toStringTree(jsonParser));

        ParseTreeWalker walker = new ParseTreeWalker();
        XMLEmitter xmlEmitter = new XMLEmitter();
        walker.walk(xmlEmitter,tree);

        System.out.println(xmlEmitter.getXML(tree));
    }
}
