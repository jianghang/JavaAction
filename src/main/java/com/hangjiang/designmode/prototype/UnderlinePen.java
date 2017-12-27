package com.hangjiang.designmode.prototype;

/**
 * Created by jianghang on 2017/12/26.
 */
public class UnderlinePen implements Product{

    private char ulchar;

    public UnderlinePen(char ulchar){
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.println(" ");
        for(int i = 0;i < length;i++){
            System.out.print(ulchar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
