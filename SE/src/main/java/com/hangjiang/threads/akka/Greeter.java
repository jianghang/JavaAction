package com.hangjiang.threads.akka;

import akka.actor.UntypedActor;

/**
 * Created by jianghang on 2017/10/22.
 */
public class Greeter extends UntypedActor{

    public enum Msg{
        GREET,DONE
    }

    @Override
    public void onReceive(Object msg) throws Exception {
        if(msg == Msg.GREET){
            System.out.println("Hello World!");
            getSender().tell(Msg.DONE,getSelf());
        } else {
            unhandled(msg);
        }
    }
}
