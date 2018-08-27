package com.etc.thread.t4;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-26 9:29
 *
 * 出现线程安全性问题条件:
 * 1   多线程环境下
 * 2   多个线程共享一个资源
 * 3    非原子性操作
 */
public class ThreadSafeProblem {
    private  int value;
    //加synchronized 解决线程安全性问题
    public synchronized  int getNext(){
       return  value++;
    }

    public static void main(String[] args) {
        ThreadSafeProblem threadSafeProblem = new ThreadSafeProblem();
        //多个线程运行就存在 数字重复的情况
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(Thread.currentThread().getName()+"--"+threadSafeProblem.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(Thread.currentThread().getName()+"--"+threadSafeProblem.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(Thread.currentThread().getName()+"--"+threadSafeProblem.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

