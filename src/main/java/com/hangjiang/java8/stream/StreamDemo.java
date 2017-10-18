package com.hangjiang.java8.stream;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jianghang on 2017/8/30.
 */
public class StreamDemo {

    private static Integer NUM = 50;

    public static void main(String[] args){
//        filterDemo();
//        mapDemo();
//        flatMapDemo();
//        distinctDemo();
        limitDemo();
    }

    private static void flatMapDemo() {
        List<String> stringList = Arrays.asList("ddd","ddd","uuuuuuu");
        List<String> strings = stringList.stream().map(s -> s.split("")).flatMap(l -> Arrays.stream(l)).distinct().collect(Collectors.toList());
        strings.stream().forEach(System.out::println);
        System.out.println(strings.toString());
    }

    private static void mapDemo() {
        List<String> stringList = Arrays.asList("ddd","ddd","uuuuuuu");
        List<Integer> integerList = stringList.stream().map(s -> s.length()).collect(Collectors.toList());
        System.out.println(integerList.toString());
    }

    private static void limitDemo() {
        List<String> stringList = Arrays.asList("ddd","ddd","uuuuuuu");
        stringList.stream().limit(2).forEach(System.out::println);
    }

    private static void distinctDemo() {
        List<String> stringList = Arrays.asList("ddd","ddd","uuuuuuu");
        stringList.stream().distinct().forEach(System.out::println);
    }

    public static void filterDemo(){
        List<String> stringList = Arrays.asList("yyyy","ddd","uuuuuuu");
        stringList.stream().filter(s -> s.length() > 1).collect(Collectors.toList()).forEach(System.out::println);

        Long count = Long.valueOf(0);
        List<Integer> strLengths = new ArrayList<>();
        for(String s : stringList){
            strLengths.add(s.length());
        }
        for(Integer i : strLengths){
            if(i > 2){
                count++;
            }
        }

        count = stringList.stream().map(s -> s.length()).filter(i -> i > 2).count();
        System.out.println("count: " + count);
    }
}
