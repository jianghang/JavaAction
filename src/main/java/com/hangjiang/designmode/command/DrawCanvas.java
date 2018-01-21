package com.hangjiang.designmode.command;

import java.awt.*;

/**
 * Created by jianghang on 2018/1/21.
 */
public class DrawCanvas extends Canvas implements Drawable{
    private Color color = Color.red;
    private int radius = 6;
    private MacroCommand history;

    public DrawCanvas(int width,int height,MacroCommand history){
        setSize(width,height);
        setBackground(Color.white);
        this.history = history;
    }

    public void paint(Graphics g){
        history.execute();
    }

    @Override
    public void draw(int x, int y) {
        Graphics graphics = getGraphics();
        graphics.setColor(color);
        graphics.fillOval(x - radius,y - radius,radius * 2,radius * 2);
    }
}
