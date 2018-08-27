package com.etc.thread.t9;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-27 22:49
 */
public class User {
    private String name;
    public  volatile int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
