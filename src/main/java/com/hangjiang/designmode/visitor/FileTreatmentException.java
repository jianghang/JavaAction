package com.hangjiang.designmode.visitor;

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
