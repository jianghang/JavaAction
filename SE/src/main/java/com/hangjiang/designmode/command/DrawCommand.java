package com.hangjiang.designmode.command;

import java.awt.*;

/**
 * Created by jianghang on 2018/1/21.
 */
public class DrawCommand implements Command{

    protected Drawable drawable;

    private Point position;

    public DrawCommand(Drawable drawable,Point position){
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x,position.y);
    }
}
