package com.hangjiang.designmode.decorator;

/**
 * Created by jianghang on 2018/1/3.
 */
public abstract class Display {

    /**
     * 获取字符数
     * @return
     */
    public abstract int getColumns();

    /**
     * 获取行数
     * @return
     */
    public abstract int getRows();

    /**
     * 获取指定的那一行的字符
     * @param row
     * @return
     */
    public abstract String getRowText(int row);

    public final void show(){
        for(int i = 0;i < getRows();i++){
            System.out.println(getRowText(i));
        }
    }
}
