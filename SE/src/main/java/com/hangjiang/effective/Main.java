package com.hangjiang.effective;

import sun.misc.Resource;

public class Main {

    public static void main(String[] args) {
        NutritionFacts nutritionFacts = new NutritionFacts.Builder(6,6).calories(33).carbohydrate(99).build();

        Resource resource = Elvis.INSTANCE.getInstance();
    }
}
