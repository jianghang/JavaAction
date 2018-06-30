package com.hangjiang.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by jianghang on 2017/7/28.
 */
public class FunctionInterfaceDemo {

    @FunctionalInterface
    interface Predicate<T>{
        boolean test(T t);
    }

    public static boolean doPredicate(int age,Predicate<Integer> predicate){
        return predicate.test(age);
    }

    public static void donation(Integer money, Consumer<Integer> consumer){
        consumer.accept(money);
    }

    public static List<Integer> supply(Integer num, Supplier<Integer> supplier){
        List<Integer> resultList = new ArrayList<>();
        for(int x = 0;x < num;x++){
            resultList.add(supplier.get());
        }

        return resultList;
    }

    public static void main(String[] args){
        boolean isAdult = doPredicate(20,x -> x >= 18);
        System.out.println(isAdult);

        donation(1000,money -> System.out.println("lambda " + money));

        List<Integer> list = supply(10,() -> (int)(Math.random() * 100));
        list.forEach(System.out :: println);

        Property p1 = new Property("叫了个鸡",1000,500,2);
        Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
        Property p3 = new Property("永和大王", 580, 3000, 1);
        Property p4 = new Property("肯德基", 6000, 200, 4);

        List<Property> properties = Arrays.asList(p1,p2,p3,p4);

        Collections.sort(properties,(x,y) -> x.getDistance().compareTo(y.getDistance()));

        String name = properties.get(0).getName();
        System.out.println("离我最近的店铺是: " + name);

        String name2 = properties.stream().sorted(Comparator.comparingInt(x -> x.getDistance())).findFirst().get().getName();

        System.out.println(name2);

        LocalDate localDate = LocalDate.now();
        System.out.println("localDate: " + localDate);

        LocalTime nowTime = LocalTime.now();
        System.out.println("nowTime: " + nowTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime: " + localDateTime);
    }
}
