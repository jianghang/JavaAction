package com.hangjiang.designmode.interpreter;

/**
 * Created by jianghang on 2018/1/25.
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        String str = "program go end";
        Node node = new ProgramNode();
        node.parse(new Context(str));
        System.out.println("node = " + node);
    }
}
