package com.hangjiang.classloader;

public class ClassLoaderMain {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path"));

        ClassLoader classLoader = ClassLoaderMain.class.getClassLoader();
        System.out.println(classLoader.toString());
        System.out.println(classLoader.getParent().toString());
    }
}
