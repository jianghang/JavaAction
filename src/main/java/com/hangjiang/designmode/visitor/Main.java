package com.hangjiang.designmode.visitor;

import java.util.Iterator;

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
        bindir.add(new File("diary.html",400));
        bindir.add(new File("index.html",500));
        tmpdir.add(new File("list.html",600));
        rootdir.accept(new ListVisitor());

        System.out.println("");

        FileFindVisitor findVisitor = new FileFindVisitor(".html");
        rootdir.accept(findVisitor);

        System.out.println("HTML files are:");
        Iterator<File> iterator = findVisitor.getFoundFiles();
        while (iterator.hasNext()){
            File file = iterator.next();
            System.out.println(file.toString());
        }
    }
}
