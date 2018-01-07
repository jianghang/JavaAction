package com.hangjiang.designmode.visitor;

/**
 * Created by jianghang on 2018/1/7.
 */
public class Main {

    public static void main(String[] args){
        System.out.println("Making root entries....");
        Directory rootdir = new Directory("root");
        Directory bindir = new Directory("bin");
        Directory tmpdir = new Directory("tmp");
        rootdir.add(bindir);
        rootdir.add(tmpdir);

        bindir.add(new File("vi",10000));
        rootdir.accept(new ListVisitor());
    }
}
