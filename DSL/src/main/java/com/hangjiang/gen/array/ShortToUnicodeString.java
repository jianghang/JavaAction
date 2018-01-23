package com.hangjiang.gen.array;

/**
 * Created by jianghang on 2018/1/23.
 */
public class ShortToUnicodeString extends ArrayInitBaseListener{

    @Override
    public void enterInit(ArrayInitParser.InitContext ctx) {
        System.out.print('"');
    }

    @Override
    public void exitInit(ArrayInitParser.InitContext ctx) {
        System.out.println('"');
    }

    @Override
    public void enterValue(ArrayInitParser.ValueContext ctx) {
        int value = Integer.valueOf(ctx.INT().getText());
        System.out.printf("\\u%04x",value);
    }
}
