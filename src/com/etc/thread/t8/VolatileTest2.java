package com.etc.thread.t8;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-27 22:01
 * //使的变量可以在 多线程中可见
 */
public class VolatileTest2 {
    public volatile int a =1 ;

    public synchronized int getA() {
        return a++;
    }

    public synchronized void setA(int a) {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.a = a;
    }
    public static void main(String[] args) {
        VolatileTest2 demo = new VolatileTest2();

        demo.a = 10;

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(demo.a);
            }
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终的结果为：" + demo.getA());
    }

}
