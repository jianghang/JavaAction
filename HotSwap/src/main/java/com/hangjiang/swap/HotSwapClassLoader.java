package com.hangjiang.swap;

/**
 * Created by jianghang on 2018/1/18.
 */
public class HotSwapClassLoader extends ClassLoader{

    public HotSwapClassLoader(){
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classByte){
        return defineClass(null,classByte,0,classByte.length);
    }
}
