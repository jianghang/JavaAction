package com.hangjiang.stringtemplate;

import org.stringtemplate.v4.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String template = "<table border=1>\n" +
                "$users:{attr | <tr><td>$attr.name$</td><td>$attr.age$</td></tr> \n}$\n" +
                "</table>";

        ST st = new ST(template,'$','$');
        Map<String,Object> item = new HashMap<>();
        item.put("name","yyy");
        item.put("age",18);

        Map<String,Object> item1 = new HashMap<>();
        item1.put("name","uuu");
        item1.put("age",88);

        List<Map<String,Object>> mapList = new ArrayList<>();
        mapList.add(item);
        mapList.add(item1);

        st.add("users",mapList);

        System.out.println(st.render());

        template = "$if(x)$ <name id = $x$/> $elseif(y)$ <age id = \"$y$\"/> $endif$";
        st = new ST(template,'$','$');
        st.add("x",false);
        st.add("y","xxx");
        System.out.println(st.render());

        System.out.println("================================");

        template = "<Input name=\"$first(name)$\" type=\"$type$\">time > '$first(time)$' and time < '$first(rest(time))$' " +
                "$if(first(rest(rest(time))))$ and time = '$first(rest(rest(time)))$' $endif$" +
                "$if(first(rest(rest(rest(time)))))$ and time = '$first(rest(rest(rest(time))))$' $endif$</Input>";
        st = new ST(template,'$','$');
        st.add("name","Condition");
        st.add("type","string");
        st.add("time","2018");
        st.add("time","2019");
        st.add("time","");
        st.add("time","2021");
        st.inspect();
        System.out.println(st.render());
    }
}
