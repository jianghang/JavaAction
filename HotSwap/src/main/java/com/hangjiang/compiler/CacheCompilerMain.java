package com.hangjiang.compiler;

import net.openhft.compiler.CompilerUtils;

public class CacheCompilerMain {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        String className = "mypackage.MyClass";
        String javaCode = "package mypackage;\n" +
                "import com.hangjiang.bo.SourceCodeEntity;\n" +
                "public class MyClass implements Runnable {\n" +
                "    public void run() {\n" +
                "        System.out.println(\"Hello World\");\n" +
                "        SourceCodeEntity entity = new SourceCodeEntity();\n" +
                "        entity.setId(1);\n" +
                "        System.out.println(\"id: \" + entity.getId());\n" +
                "    }\n" +
                "}\n";
        Class aClass = CompilerUtils.CACHED_COMPILER.loadFromJava(className, javaCode);
        Runnable runner = (Runnable) aClass.newInstance();
        new Thread(runner).start();
    }
}
