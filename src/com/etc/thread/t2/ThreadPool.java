package com.etc.thread.t2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-22 20:36
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"is running");
                }
            });
        }
        executorService.shutdown();

//        Executor executor = Executors.newFixedThreadPool(10);
//        for(int i=0;i<100;i++){
//            executor.execute(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName()+"is running");
//                }
//            });
//        }
    }
}
