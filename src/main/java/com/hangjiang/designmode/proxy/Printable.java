package com.hangjiang.designmode.proxy;

/**
 * Created by jianghang on 2018/1/21.
 */
public interface Printable {
    void setPrinterName(String name);
    String getPrinterName();
    void print(String string);
}
