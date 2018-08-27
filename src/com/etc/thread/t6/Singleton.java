package com.etc.thread.t6;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-27 20:23
 * 单例模式 与线程安全性问题
 * 分 饿汉式，懒汉式
 * 饿汉式 是不存在线程 安全性问题
 * 出现线程安全性的条件是：
 * 1  在多线程环境下
 * 2   存在共享资源
 * 3  非原子性操作
 */
public class Singleton {
    private  static  Singleton instance = new Singleton();// 饿汉式
    private Singleton(){}

    public static  Singleton getInstance(){
        return instance;
    }


}
