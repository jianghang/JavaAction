package com.hangjiang.actions.csv;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    public static void main(String[] args) {
        String csv = "Details,Month,Amount\n" +
                "Mid Bonus,June,\"$2,000\"\n" +
                ",January,\"\"\"zippo\"\"\"\n" +
                "Total Bonuses,\"\",\"$5,000\"\n";
        CharStream charStream = CharStreams.fromString(csv);
        CSVLexer lexer = new CSVLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        CSVParser parser = new CSVParser(tokenStream);
        parser.file();
    }
}
