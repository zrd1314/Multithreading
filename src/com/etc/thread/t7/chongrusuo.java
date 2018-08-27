package com.etc.thread.t7;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-27 20:55
 * synchronized  是可 重入 的  是 重入锁 意思就是 用synchronized 锁住的实例对象是 可以相互访问的
 *
 */
public class chongrusuo {
    public synchronized  void a(){
        System.out.println("aaaa");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //b();
    }
    public synchronized  void b(){
        System.out.println("bbb");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        chongrusuo c1 =new chongrusuo();
        chongrusuo c2 =new chongrusuo();
//        new Thread(new Runnable() { //执行的很快，并没有 因为 先执行 a（）方法锁定了 当前实例对象，而b方法无法访问
//            @Override
//            public void run() {
//                c1.a();
//            }
//        }).start();

        new Thread(new Runnable() { //执行的很快，并没有 因为 先执行 a（）方法锁定了 当前实例对象，而b方法无法访问
            @Override
            public void run() {
                c1.a();
            }
        }).start();
        new Thread(new Runnable() { //执行的很快，并没有 因为 先执行 a（）方法锁定了 当前实例对象，而b方法无法访问
            @Override
            public void run() {
                c2.b();
            }
        }).start();
    }
}
