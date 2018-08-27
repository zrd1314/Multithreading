package com.etc.thread.t6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-27 20:37
 */
public class TestSingleton2 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(20);
        for(int i=0;i<50;i++){
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"--"+Singleton2.getInstance3());
                }
            });
        }
    }
}
