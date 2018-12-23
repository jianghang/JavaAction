package com.hangjiang.algorithms;

import edu.princeton.cs.algs4.StdIn;

public class BinarySearch {

    public static void main(String[] args) {
        while (StdIn.hasNextChar()){
            String str = StdIn.readString();
            if("".equals(str)){
                break;
            }
            System.out.println(str);
        }
        int[] data = new int[]{2,3,5,7,9,10};
        int seek = rank(5,data,0,data.length - 1);
        System.out.println(seek);
    }

    private static int rank(int key, int[] data, int i1, int i2) {
        if(i1 > i2){
            return -1;
        }

        int mid = i1 + (i2 - i1) / 2;
        if(key > data[mid]){
            return rank(key,data,mid + 1,i2);
        }else if(key < data[mid]){
            return rank(key,data,i1,mid - 1);
        }else {
            return mid;
        }
    }
}
