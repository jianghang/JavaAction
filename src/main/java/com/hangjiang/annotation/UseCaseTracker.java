package com.hangjiang.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jianghang on 2017/10/18.
 */
public class UseCaseTracker {
    public static void trackUserCases(List<Integer> useCases,Class<?> cls){
        for(Method m : cls.getDeclaredMethods()){
            UseCase useCase = m.getAnnotation(UseCase.class);
            if(useCase != null){
                System.out.println("Found Use Case: " + useCase.id() + " " + useCase.description());
            }
        }

        for(int i : useCases){
            System.out.println("Warning: Missing user case-" + i);
        }
    }

    public static void main(String[] args){
        List<Integer> useCases = new ArrayList<>();
        Collections.addAll(useCases,47,48,49,50);
        trackUserCases(useCases,PasswordUtils.class);
    }
}
