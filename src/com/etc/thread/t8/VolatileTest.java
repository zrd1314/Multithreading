package com.etc.thread.t8;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-27 21:25
 * volatile :  被volatile修饰的 变量 ，在线程之间是可见的
 * 可见意思:  当一个线程修改了值，另外一个线程能读到修改后的值
 * synchronized： 除了线程的互斥之外，还有一个非常大作用就是保证可见性
 *
 * 使用volatile 修饰变量  当 变量进行非原子性 操作时，也是不能保证线程的安全性
 * 只有当 进入 原子性操作时 使用volatile 效率比synchronized高
 */
public class VolatileTest {
    public volatile boolean run = false ;

    public static void main(String[] args) {
        VolatileTest v = new VolatileTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=1;i<=10;i++){
                    System.err.println("执行了"+i+"次");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                v.run =true;
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
               while(!v.run){
                   //自旋
               }
                System.out.println("线程2开始执行了。。。");
            }
        }).start();

    }

}
