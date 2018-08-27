package com.etc.thread.t7;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-27 21:15
 */
public class DeadLock {
    private Object o1 = new Object();
    private  Object o2 = new Object();

    public void a(){
        synchronized (o1){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println("a");
            }
        }
    }

    public void b(){
        synchronized (o2){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("b");
            }
        }
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.a();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadLock.b();
            }
        }).start();
    }
}
