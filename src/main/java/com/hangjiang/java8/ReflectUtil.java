package com.hangjiang.java8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jianghang on 2017/8/10.
 */
public class ReflectUtil {

    public static void beanTrim(Object obj) {
        Map<String,Method> methodMap = Stream.of(obj.getClass().getMethods())
                .filter(method -> method.getName().startsWith("get"))
                .filter(method -> !method.getName().equals("getClass"))
                .collect(Collectors.toMap((Method method) -> method.getName().substring(3, method.getName().length()), (p) -> p));

        Stream.of(obj.getClass().getMethods()).filter(method -> method.getName().startsWith("set")).forEach((method) -> {
            String name = method.getName();
            String field = method.getName().substring(3,name.length());
            Method getMethod = methodMap.get(field);
            if(getMethod != null){
                try {
                    Object value = getMethod.invoke(obj);
                    if(value != null && value instanceof String){
                        method.invoke(obj,value.toString().trim());
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        Property property = new Property("   永和大王  ", 580, 3000, 1);
        System.out.println(property.toString());
        beanTrim(property);
        System.out.println(property.toString());
    }
}
