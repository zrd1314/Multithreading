package com.etc.thread.t1;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-21 21:04
 * wait 等待状态 知道 遇到 notify 或者notfiyAll 线程才会被唤醒
 */
public class MyThread implements Runnable {
    @Override
    public synchronized  void run() {
        while (true){

//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            try {

                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"自定义线程在执行");
        }

    }

    public static void main(String[] args) {
        //使用wait 和 notify 是 需要使用 同步监视器的
        MyThread my = new MyThread();
        Thread thread = new Thread(my); //线程的初始化状态
        thread.start(); //ready to run 就绪状态 竞争cpu资源
        while(true){
            synchronized (my){ //必须是 当前类的实例
                System.out.println(Thread.currentThread().getName()+"主线程在执行");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                my.notifyAll();
            }

        }


    }
}
