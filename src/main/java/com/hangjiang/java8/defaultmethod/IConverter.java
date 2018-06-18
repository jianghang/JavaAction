package com.hangjiang.java8.defaultmethod;

/**
 * Created by jianghang on 2018/5/12.
 */
public interface IConverter<T,R> {

    void convert(T source,R result);
}
