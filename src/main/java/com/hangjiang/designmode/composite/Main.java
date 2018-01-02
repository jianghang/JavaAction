package com.hangjiang.designmode.composite;

/**
 * Created by jianghang on 2018/1/2.
 */
public class Main {

    public static void main(String[] args){
        System.out.println("Making root entries...");
        Directory rootdir = new Directory("root");
        Directory bindir = new Directory("bin");
        Directory tmpdir = new Directory("tmp");
        Directory usrdir = new Directory("usr");

        rootdir.add(bindir);
        rootdir.add(tmpdir);
        rootdir.add(usrdir);

        File vi = new File("vi",10000);
        bindir.add(vi);
        bindir.add(new File("latex",20000));
        rootdir.add(new File("test",30000));
        rootdir.printList();

        System.out.println();
        System.out.println(vi.getFullName());
    }
}
