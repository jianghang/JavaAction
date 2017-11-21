package com.hangjiang.annotation;

import com.alibaba.fastjson.JSON;
import scala.Int;

import javax.validation.constraints.Size;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianghang on 2017/11/21.
 */
public class SizeAnnotationProcessor {

    public static void main(String[] args) throws IllegalAccessException {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("kkkkkkllllll");
        userInfo.setAge("1111");
        userInfo.setPhoneNumber("124999999988");
        userInfo.setCreateTime("2017");

        UserInfo info  = new UserInfo();
        info.setName("hang");
        info.setAge("11");
        info.setPhoneNumber("123456789");

        List<UserInfo> userInfos = new ArrayList<>();
        userInfos.add(userInfo);
        userInfos.add(info);

        List<UserInfo> errorData = validateData(userInfos);
        System.out.println("All: " + JSON.toJSON(userInfos));
        userInfos.removeAll(errorData);
        System.out.println("remain: " + JSON.toJSON(userInfos));
        System.out.println(JSON.toJSON(errorData));
    }

    public static <T> List<T> validateData(List<T> tList) throws IllegalAccessException {
        List<T> list = new ArrayList<>();
        for(T t : tList){
            Field[] fields = t.getClass().getDeclaredFields();
            for(Field f : fields){
                Size size = f.getAnnotation(Size.class);
                if(size == null) continue;

                Integer max = size.max();
                f.setAccessible(true);
                String value = (String) f.get(t);
                Integer len = value == null ? 0 : value.length();
                System.out.println(value);
                if(len > max){
                    list.add(t);
                    break;
                }
            }
        }

        return list;
    }
}
