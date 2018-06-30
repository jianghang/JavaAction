package com.hangjiang.java8.lambda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by jianghang on 2017/8/30.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}
