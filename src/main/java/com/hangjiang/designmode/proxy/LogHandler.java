package com.hangjiang.designmode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by jianghang on 2017/5/22.
 */
public class LogHandler implements InvocationHandler {

    private Object obj;

    public LogHandler(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.doBefore();
        System.out.println(proxy.getClass());
        Object o = method.invoke(obj,args);
        System.out.println("result: " + o);
        this.doAfter();

        return o;
    }

    public void doBefore(){
        System.out.println("proxy: do this before.");
    }

    public void doAfter(){
        System.out.println("proxy: do this after.");
    }
}
