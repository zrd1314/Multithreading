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
public class ThreadCreate  extends  Thread{
    public ThreadCreate(String name){
        super(name);
    }

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName()+"在执行。。。。");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        ThreadCreate t1 = new ThreadCreate("first-thread");
        ThreadCreate t2 = new ThreadCreate("secode-thread");
        //设置为 守护线程  当主线程 执行完毕后 ，守护线程 会自动跳出
        t1.setDaemon(true);
        t2.setDaemon(true);  //由于 设置了 守护线程 ，线程 任务又是并发执行的 当主线程 执行完毕后，守护线程 代码就不执行了
        t1.start();
        t2.start();
        try {
            Thread.sleep(2000); //让主线程 休息2秒 给 守护线程执行机会
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
