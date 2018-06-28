package com.hangjiang.listeners.cymbol;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.misc.OrderedHashSet;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Set;

public class CallGraph {

    public static class Graph {
        Set<String> nodes = new OrderedHashSet<>();
        MultiMap<String, String> edges = new MultiMap<>();

        public void edge(String source, String target) {
            edges.map(source, target);
        }

        public String toDOT() {
            StringBuilder builder = new StringBuilder();
            builder.append("digraph G {\n");
            builder.append("    ranksep = .25;\n");
            builder.append("    edge [arrowsize = .5]\n");
            builder.append("    node [shape = circle, fontname = \"ArialNarrow\",\n");
            builder.append("        fontsize = 12,fixedsize = true, height = .45];\n");
            builder.append("    ");
            nodes.forEach(node -> {
                builder.append(node);
                builder.append("; ");
            });

            builder.append("\n");
            edges.keySet().forEach(src -> {
                edges.get(src).forEach(trg -> {
                    builder.append("  ");
                    builder.append(src);
                    builder.append(" -> ");
                    builder.append(trg);
                    builder.append(";\n");
                });
            });

            builder.append("}\n");

            return builder.toString();
        }
    }

    public static class FunctionListener extends CymbolBaseListener {
        Graph graph = new Graph();
        String currentFunctionName = null;

        @Override
        public void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
            currentFunctionName = ctx.ID().getText();
            graph.nodes.add(currentFunctionName);
        }

        @Override
        public void exitCall(CymbolParser.CallContext ctx) {
            String funcName = ctx.ID().getText();
            graph.edge(currentFunctionName, funcName);
        }
    }

    public static void main(String[] args) {
        String cy = "int main() { fact(); a(); }\n" +
                "\n" +
                "float fact(int n) {\n" +
                "  print(n);\n" +
                "  \n" +
                "  if ( n==0 ) then return 1;\n" +
                "  return n * fact(n-1);\n" +
                "}\n" +
                "\n" +
                "void a() { int x = b(); if false then {c(); d();} }\n" +
                "void b() { c(); }\n" +
                "void c() { b(); }\n" +
                "void d() { }\n" +
                "void e() { }";
        CharStream charStream = CharStreams.fromString(cy);
        CymbolLexer lexer = new CymbolLexer(charStream);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        CymbolParser parser = new CymbolParser(tokenStream);
        ParseTree tree = parser.file();
        FunctionListener functionListener = new FunctionListener();

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(functionListener,tree);

        System.out.println(functionListener.graph.toDOT());
    }
}
