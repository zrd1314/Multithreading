package com.etc.thread.t2;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-21 22:21
 *
 * 线程创建的几种方式
 * 1   extends  Thread
 * 2 实现 Runnable 接口
 * 3  匿名内部类
 * 4  带返回值的线程
 * 5  线程池
 * 6 Lambda 表达式
 * 7 定时器
 * 8 Spring
 *
 */
public class ThreadCreateInturrped extends  Thread{
    public ThreadCreateInturrped(String name){
        super(name);
    }

    @Override
    public void run() {
        while(!interrupted()){
            System.out.println(Thread.currentThread().getName()+"在执行。。。。");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ThreadCreateInturrped t1 = new ThreadCreateInturrped("first1-thread");
        ThreadCreateInturrped t2 = new ThreadCreateInturrped("secode2-thread");

        t1.start();
        t2.start();

     t1.interrupt(); //中断线程t1

    }
}
