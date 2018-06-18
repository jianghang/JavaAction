package com.hangjiang.property;

import org.antlr.v4.misc.OrderedHashMap;

import java.util.Map;

public class PropertyFileLoader extends PropertyFileBaseListener {

    protected Map<String, String> props = new OrderedHashMap<>();

    @Override
    public void exitProp(PropertyFileParser.PropContext ctx) {
        String id = ctx.ID().getText();
        String value = ctx.STRING().getText();
        props.put(id, value);
    }
}
