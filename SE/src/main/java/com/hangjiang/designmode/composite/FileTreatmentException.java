package com.hangjiang.designmode.composite;

/**
 * Created by jianghang on 2018/1/2.
 */
public class FileTreatmentException extends RuntimeException {
    public FileTreatmentException(){

    }

    public FileTreatmentException(String msg){
        super(msg);
    }
}
