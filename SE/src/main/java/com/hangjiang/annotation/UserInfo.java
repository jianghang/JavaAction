package com.hangjiang.annotation;

import javax.validation.constraints.Size;

/**
 * Created by jianghang on 2017/11/21.
 */
public class UserInfo {

    @Size(min = 2,max = 16)
    private String name;

    @Size(max = 3)
    private String age;

    @Size(max = 11)
    private String phoneNumber;

    private String createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
