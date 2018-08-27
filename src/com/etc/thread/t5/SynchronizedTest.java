package com.etc.thread.t5;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-26 10:04
 * synchronized 的使用(内置锁和 互斥锁)
 * 1当作用在 实例方法上面 ，作用的内部锁为  当前类的实例(SynchronizedTest的实例对象)
 * 2  当 作用在 静态方法 上 ，指的是 当前类的Class 对象(SynchronizedTest.class)
 * 3 同步代码块时， 作用是 整个object实例，可以自己指定
 *
 */
// 任何对象都可以作为锁， 那么 锁是 存在在 什么对象的什么位置？  在 对象头中
    //  对象头中的信息
    //  Mark Word  （存在对象的hash值， 锁的标志位）
    // Class Metadata Address
    /**
     *  每次获取锁 和释放锁胡浪费资源， 很多情况下，竞争锁不是由多个线程，而是由一个线程在使用
     * 偏向锁: Mark Word 的状态( 线程id，Epoch, 对象的分代年龄信息 ，是否为偏向锁，锁标志位)
     *
     * 什么情况使用偏向锁：  只有一个线程在访问同步代码块的场景
     *
     * 轻量级锁： 多个线程可以同时
     * 重量级锁： 升级到synchronized， 一个线程在执行 ，其他线程全部处于等待状态
     * */
public class SynchronizedTest {
    private int value ;

    private  static int value1;

    //内部锁为 SynchronizedTest的实例对象
    public synchronized  int getNext(){
        return value++;
    }

    //内部锁为 SynchronizedTest.class
    public  synchronized static int getPre(){
        return value1 -- ;
    }

    public int test(){
//        synchronized (this){ //同步代码块 锁定当前实例对象
//            if(value ==0){
//                return value;
//            }
//            return -1;
//        }


        synchronized (SynchronizedTest.class){ //同步代码块 锁定当前Class实例对象
            if(value ==0){
                return value;
            }
            return -1;
        }


    }
    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        //多个线程运行就存在 数字重复的情况
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(Thread.currentThread().getName()+"--"+synchronizedTest.getPre());
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
                    System.out.println(Thread.currentThread().getName()+"--"+synchronizedTest.getPre());
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
                    System.out.println(Thread.currentThread().getName()+"--"+synchronizedTest.getPre());
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
