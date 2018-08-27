package com.etc.thread.t6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-27 20:30
 */
public class TestSinleton {
    public static void main(String[] args) {
//        Singleton s1 =Singleton.getInstance();
//        Singleton s2 =Singleton.getInstance();
//        System.out.println(s1);
//        System.out.println(s2);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"--"+Singleton.getInstance());
                }
            });
        }

    }
}
