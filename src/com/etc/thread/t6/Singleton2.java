package com.etc.thread.t6;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-27 20:35
 *
 */
public class Singleton2 {
    //volatile 防止jvm 指令重排序
    private  volatile  static  Singleton2 instance = null; //懒汉式 存在线程安全性问题
    private Singleton2(){}

    public static  Singleton2 getInstance(){  //多线程情况该代码存在 问题，原因非原子性操作
        if(instance == null){
            instance = new Singleton2();
        }
        return instance ;
    }

    public static synchronized Singleton2 getInstance1(){  //使用synchronized 太重影响效率，
        if(instance == null){
            instance = new Singleton2();
        }
        return instance ;
    }
    //使用双重检查加锁
    public static Singleton2 getInstance3(){
        if(instance == null){  //当instance 不为空，同步代码块不会执行，效率高
            synchronized (Singleton2.class){
                if (instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return  instance;
    }


}
