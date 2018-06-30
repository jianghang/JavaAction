package com.hangjiang.designmode.decorator;

/**
 * Created by jianghang on 2018/1/7.
 */
public class UpDownBorder extends Border{

    private char borderChar;

    protected UpDownBorder(Display display,char borderChar) {
        super(display);
        this.borderChar = borderChar;
    }

    @Override
    public int getColumns() {
        return display.getColumns();
    }

    @Override
    public int getRows() {
        return 1 + display.getRows() + 1;
    }

    @Override
    public String getRowText(int row) {
        if(row == 0){
            return makeLine(borderChar,display.getColumns());
        }else if(row == display.getRows() + 1){
            return makeLine(borderChar,display.getColumns());
        }else{
            return display.getRowText(row - 1);
        }
    }

    private String makeLine(char borderChar, int columns) {
        StringBuffer buffer = new StringBuffer();
        for(int i = 0;i < columns;i++){
            buffer.append(borderChar);
        }
        return buffer.toString();
    }
}
