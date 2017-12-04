package com.hangjiang.threads.designmode.single_threaded_execution;

/**
 * Created by jianghang on 2017/12/3.
 */
public class UserThread extends Thread{
    private final Gate gate;
    private final String myname;
    private final String myaddress;

    public UserThread(Gate gate,String name,String myaddress){
        this.gate = gate;
        this.myname = name;
        this.myaddress = myaddress;
    }

    @Override
    public void run() {
        System.out.println(myname + " BEGIN");
        while (true){
            gate.pass(myname,myaddress);
        }
    }
}
