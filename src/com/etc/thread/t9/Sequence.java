package com.etc.thread.t9;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-27 22:44
 */
public class Sequence {
    //使用jdk 提供的原子性 类 来解决 自增的线程安全性问题
    AtomicInteger atomicInteger = new AtomicInteger(0);
    AtomicReference<User> userAtomicReference = new AtomicReference<>();
    AtomicIntegerFieldUpdater<User> userAtomicIntegerFieldUpdater =AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    public  int getNext(){
        int andIncrement = atomicInteger.getAndIncrement();
        User user = new User();
        System.out.println(Thread.currentThread().getName()+"第一个值为"+userAtomicIntegerFieldUpdater.getAndIncrement(user));
        System.out.println(Thread.currentThread().getName()+"第二个值为"+userAtomicIntegerFieldUpdater.getAndIncrement(user));
        System.out.println(Thread.currentThread().getName()+"第三个值为"+userAtomicIntegerFieldUpdater.getAndIncrement(user));

        return andIncrement;
    }

    public static void main(String[] args) {
        Sequence s1 = new Sequence();
        new Thread(new Runnable() {
            @Override
            public void run() {
               // while(true){
                    System.out.println(Thread.currentThread().getName()+"--"+s1.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
               // }

            }
        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//                    System.out.println(Thread.currentThread().getName()+"--"+s1.getNext());
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//            }
//        }).start();
    }
}
