package com.hangjiang.threads.akka;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

/**
 * Created by jianghang on 2017/10/22.
 */
public class HelloWorld extends UntypedActor{

    private ActorRef greeter;

    @Override
    public void preStart() throws Exception {
        greeter = getContext().actorOf(Props.create(Greeter.class),"greeter");
        System.out.println("Greeter Actor Path: " + greeter.path());
        greeter.tell(Greeter.Msg.GREET,getSelf());
    }

    @Override
    public void onReceive(Object msg) throws Exception {
        if(msg == Greeter.Msg.DONE){
            greeter.tell(Greeter.Msg.GREET,getSelf());
            getContext().stop(getSelf());
        }else {
            unhandled(msg);
        }
    }
}
