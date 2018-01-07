package com.hangjiang.designmode.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghang on 2018/1/7.
 */
public class MultiStringDisplay extends Display {

    private List<String> stringList;
    private int colums;

    public MultiStringDisplay() {
        stringList = new ArrayList<>();
    }

    @Override
    public int getColumns() {
        return colums;
    }

    @Override
    public int getRows() {
        return stringList.size();
    }

    @Override
    public String getRowText(int row) {
        return stringList.get(row);
    }

    public void add(String s) {
        stringList.add(s);
        updateColums(s);
    }

    private void updateColums(String s) {
        if (s.getBytes().length > colums) {
            colums = s.getBytes().length;
            for (int i = 0; i < stringList.size() - 1; i++) {
                String str = stringList.get(i);
                int num = colums - str.getBytes().length;
                String newStr = makeSpaces(num, str);
                stringList.set(i, newStr);
            }
        } else {
            int num = colums - s.getBytes().length;
            String newStr = makeSpaces(num,s);
            stringList.set(stringList.size() - 1,newStr);
        }
    }

    private String makeSpaces(int num, String str) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(str);
        for (int i = 0; i < num; i++) {
            buffer.append(" ");
        }
        return buffer.toString();
    }
}
