package com.hangjiang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jianghang on 2017/11/29.
 */
public class RegexAction {

    public static void main(String[] args){
        String regexStr = "(?:')(.*?)(?:')";

        String str = "yy = 'kkkklkakdlfkaj)(' 'kjdskfjldsa'";

        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
