package com.hangjiang.listeners.csv;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LoadCSV {

    public static class Loader extends CSVBaseListener{
        public static final String EMPTY = "";

        List<Map<String,String>> rows = new ArrayList<>();

        List<String> header;

        List<String> currentRowFieldValues;

        @Override
        public void exitString(CSVParser.StringContext ctx) {
            currentRowFieldValues.add(ctx.STRING().getText());
        }

        @Override
        public void exitText(CSVParser.TextContext ctx) {
            currentRowFieldValues.add(ctx.TEXT().getText());
        }

        @Override
        public void exitEmpty(CSVParser.EmptyContext ctx) {
            currentRowFieldValues.add(EMPTY);
        }

        @Override
        public void exitHdr(CSVParser.HdrContext ctx) {
            header = new ArrayList<>();
            header.addAll(currentRowFieldValues);
        }

        @Override
        public void enterRow(CSVParser.RowContext ctx) {
            currentRowFieldValues = new ArrayList<>();
        }

        @Override
        public void exitRow(CSVParser.RowContext ctx) {
//            if(ctx.parent instanceof CSVParser.HdrContext) return;
            if(ctx.getParent().getRuleIndex() == CSVParser.RULE_hdr) return;

            Map<String,String> map = new LinkedHashMap<>();
            int i = 0;
            for(String v : currentRowFieldValues){
                map.put(header.get(i),v);
                i++;
            }

            rows.add(map);
        }
    }

    public static void main(String[] args) {
        String csvStr = "Details,Month,Amount\n" +
                "Mid Bonus,June,\"$2,000\"\n" +
                ",January,\"\"\"zippo\"\"\"\n" +
                "Total Bonuses,\"\",\"$5,000\"\n";
        CharStream charStream = CharStreams.fromString(csvStr);
        CSVLexer lexer = new CSVLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        CSVParser csvParser = new CSVParser(tokenStream);
        ParseTree tree = csvParser.file();

        Loader loader = new Loader();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(loader,tree);

        System.out.println(loader.rows);
    }
}
