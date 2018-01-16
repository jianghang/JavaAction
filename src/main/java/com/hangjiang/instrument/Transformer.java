package com.hangjiang.instrument;

import java.io.*;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * Created by jianghang on 2018/1/14.
 */
public class Transformer implements ClassFileTransformer{

    public static final String classNumberReturns2 = "TransClass.class.2";

    public static byte[] getBytesFromFile(String fileName){
        File file = new File(fileName);
        try {
            InputStream inputStream = new FileInputStream(file);
            long length = file.length();
            byte[] bytes = new byte[(int) length];

            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length && (numRead = inputStream.read(bytes,offset,bytes.length - offset)) >= 0){
                offset += numRead;
            }

            if(offset < bytes.length){
                throw new IOException("Could not completely read file " + fileName);
            }
            inputStream.close();
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("ClassName: " + className);
        if(!className.equals("TransClass")){
            return null;
        }
        return getBytesFromFile(classNumberReturns2);
    }
}
