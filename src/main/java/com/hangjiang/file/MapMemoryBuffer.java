package com.hangjiang.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by jianghang on 2017/12/3.
 */
public class MapMemoryBuffer {

    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 1024 * 5);

        FileInputStream fileInputStream = new FileInputStream("/Users/jianghang/Downloads/algs4-data/largeDG.txt");
        FileChannel fileChannel = fileInputStream.getChannel();
        fileChannel.read(byteBuffer);
        System.out.println("FileSize: " + fileChannel.size() / 1024);
    }
}
