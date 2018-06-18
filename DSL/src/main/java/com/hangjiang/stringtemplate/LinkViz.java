package com.hangjiang.stringtemplate;

import java.util.ArrayList;
import java.util.List;

public class LinkViz {

    List<Link> links = new ArrayList<>();

    public static class Link{
        String from;
        String to;

        public Link(String from,String to){
            this.from = from;
            this.to = to;
        }
    }

    public LinkViz(){

    }

    @Override
    public String toString() {
        return null;
    }
}
