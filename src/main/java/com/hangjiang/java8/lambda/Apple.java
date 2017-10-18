package com.hangjiang.java8.lambda;

/**
 * Created by jianghang on 2017/8/30.
 */
public class Apple {
    private String color;
    private Integer weight;

    public Apple(String color,Integer weight){
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
