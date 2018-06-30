package com.hangjiang.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by jianghang on 2017/9/27.
 */
public class PomUtil {

    public static void main(String[] args) throws IOException {
        String path = PomUtil.class.getResource("/").getPath();
        System.out.println(path);

        String userPath = System.getProperty("user.dir");
        System.out.println(userPath);
        String libPath = userPath + "/lib";
        System.out.println(libPath);

        File libDir = new File(libPath);
        System.out.println(libDir.isDirectory());
        File[] files = libDir.listFiles();
        for (File file : files) {
            if(file.getName().equals("axis2-transport-local-1.6.2.jar")){
                System.out.println(file.getName());
                JarFile jarFile = new JarFile(file);
                Enumeration<JarEntry> enumeration = jarFile.entries();
                while (enumeration.hasMoreElements()){
                    JarEntry jarEntry = enumeration.nextElement();
                    System.out.println(jarEntry.getName());

                    if(jarEntry.getName().contains("pom.properties")){
                        JarFile jarFile1 = new JarFile(libPath + "/axis2-transport-local-1.6.2.jar");
                        InputStream inputStream = jarFile1.getInputStream(jarEntry);
                        InputStreamReader reader = new InputStreamReader(inputStream);
                        BufferedReader bufferedReader = new BufferedReader(reader);
                        String line;
                        while((line = bufferedReader.readLine()) != null){
                            System.out.println(line);
                        }

                        bufferedReader.close();
                        reader.close();
                        inputStream.close();
                    }
                }
            }
        }

    }
}
