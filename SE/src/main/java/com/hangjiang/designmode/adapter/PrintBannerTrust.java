package com.hangjiang.designmode.adapter;

/**
 * Created by jianghang on 2017/12/25.
 */
public class PrintBannerTrust extends PrintTrust{

    private Banner banner;

    public PrintBannerTrust(String string){
        this.banner = new Banner(string);
    }

    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
