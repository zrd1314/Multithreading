package com.etc.thread.t2;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-22 20:24
 */
public class AyThread {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println("线程 is running");
            }
        }.start();
    }


}
