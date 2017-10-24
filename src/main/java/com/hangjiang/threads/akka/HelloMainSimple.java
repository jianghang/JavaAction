package com.hangjiang.threads.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.ConfigFactory;

/**
 * Created by jianghang on 2017/10/22.
 */
public class HelloMainSimple {

    public static void main(String[] args){
        ActorSystem system = ActorSystem.create("Hello", ConfigFactory.load("samplehello.conf"));
        ActorRef actorRef = system.actorOf(Props.create(HelloWorld.class),"helloWorld");
        System.out.println("HelloWorld Actor Path: " + actorRef.path());
    }
}
