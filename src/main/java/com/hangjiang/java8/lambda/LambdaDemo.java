package com.hangjiang.java8.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by jianghang on 2017/8/30.
 */
public class LambdaDemo {

    public static void main(String[] args) throws IOException {
//        simpleDemo();

//        appleDemo();

//        System.out.println(processFile((BufferedReader br) -> br.readLine() + br.readLine()));

//        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.trim().isEmpty();
//        List<String> nonEmpty = filter(Arrays.asList("1","2","","5"," "),nonEmptyStringPredicate);
//        System.out.println(nonEmpty.toString());

//        forEach(Arrays.asList(1,2,3,5,6),(Integer i) -> System.out.println(i));
//
        List<Integer> integerList = map(Arrays.asList(" yyyy ","ddd","uuuuuuu "),(String s) -> s.length());
        System.out.println(integerList.toString());
        List<String> stringList = map(Arrays.asList(" yyyy ","ddd","uuuuuuu "),(String s) -> s.trim());
        System.out.println(stringList);
//
//        forEach(Arrays.asList(1,2,3,5,6), System.out::println);
    }

    private static void simpleDemo() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Thread!");
            }
        }).start();

        new Thread(() -> System.out.println("Hello Lambda")).start();
    }

    private static void appleDemo() {
        Comparator<Apple> byWeight = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        };

        Comparator<Apple> byWeight_lambda = (Apple a1,Apple a2) -> a1.getWeight().compareTo(a2.getWeight());

        Apple a1 = new Apple("red",3);
        Apple a2 = new Apple("green",4);
        System.out.println(byWeight_lambda.compare(a1,a2));
    }

    public static String processFile(BufferedReaderProcessor processor) throws IOException{

        try(BufferedReader br = new BufferedReader(new FileReader("./data.txt"))) {
            return processor.process(br);
        }
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> results = new ArrayList<>();
        for(T t: list){
            if(p.test(t)){
                results.add(t);
            }
        }

        return results;
    }

    public static <T> void forEach(List<T> list, Consumer<T> c){
        for(T i : list){
            c.accept(i);
        }
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for(T s : list){
            result.add(f.apply(s));
        }

        return result;
    }
}
