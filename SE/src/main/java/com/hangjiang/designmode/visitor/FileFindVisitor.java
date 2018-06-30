package com.hangjiang.designmode.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jianghang on 2018/1/22.
 */
public class FileFindVisitor extends Visitor{

    private String filename;
    private List<File> foundFiles;

    public FileFindVisitor(String filename){
        this.filename = filename;
        foundFiles = new ArrayList<>();
    }

    @Override
    public void visit(File file) {
        if(file.getName().lastIndexOf(filename) != -1){
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        Iterator iterator = directory.iterator();
        while (iterator.hasNext()){
            Entry entry = (Entry) iterator.next();
            entry.accept(this);
        }
    }

    public Iterator<File> getFoundFiles() {
        return foundFiles.iterator();
    }
}
