package com.etc.thread.t3;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-26 9:19
 */
public class ThreadRunnable implements Runnable {
    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName()+"--");
        }
    }
}
