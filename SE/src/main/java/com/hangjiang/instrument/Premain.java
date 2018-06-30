package com.hangjiang.instrument;

import java.lang.instrument.Instrumentation;

/**
 * Created by jianghang on 2018/1/14.
 */
public class Premain {

    public static void premain(String agentArgs, Instrumentation inst){
        inst.addTransformer(new Transformer());
    }
}
