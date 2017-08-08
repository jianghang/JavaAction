package com.hangjiang.reflect;

import com.hangjiang.designmode.proxy.CalculatorImpl;
import com.hangjiang.designmode.proxy.CalculatorProxy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by jianghang on 2017/5/22.
 */
public class ReflectAction {

    public void getClassInformation(Object obj) throws InvocationTargetException, IllegalAccessException {
        Class clazz = obj.getClass();

        String className = clazz.getName();
        System.out.println("className: " + className);
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            if("add".equals(method.getName())){
                Object result = method.invoke(obj,new Object[]{1,2});
                System.out.println(result);
            }
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ReflectAction action = new ReflectAction();
        action.getClassInformation(new CalculatorProxy(new CalculatorImpl()));
    }
}
