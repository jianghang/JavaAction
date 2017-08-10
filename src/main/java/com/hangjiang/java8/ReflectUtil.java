package com.hangjiang.java8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jianghang on 2017/8/10.
 */
public class ReflectUtil {

    public static void beanTrim(Object obj) {
        Map<String,Method> methodMap = Stream.of(obj.getClass().getMethods())
                .parallel()
                .filter(method -> method.getName().startsWith("get"))
                .filter(method -> !method.getName().equals("getClass"))
                .collect(Collectors.toMap((Method method) -> method.getName().substring(3, method.getName().length()), (p) -> p));

        Stream.of(obj.getClass().getMethods()).filter(method -> method.getName().startsWith("set")).forEach((method) -> {
            String name = method.getName();
            String field = method.getName().substring(3,name.length());
            Optional.ofNullable(methodMap.get(field)).ifPresent(method1 -> {
                try {
                    Optional.ofNullable(method1.invoke(obj)).ifPresent(p -> {
                        if(p instanceof String){
                            try {
                                method.invoke(obj,p.toString().trim());
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        });
    }

    public static void main(String[] args) {
        Property property = new Property("   永和大王  ", 580, 3000, 1);
//        property.setName(null);
        System.out.println(property.toString());
        long currentTime = System.currentTimeMillis();
        beanTrim(property);
        System.out.println(System.currentTimeMillis() - currentTime);
        System.out.println(property.toString());
    }
}
