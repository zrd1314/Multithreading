package com.etc.thread.t3;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-26 9:15
 * 线程安全性问题
 * 饥饿与公平问题：
 *  高优先级吞噬 低优先级的cpu时间片
 *  线程被永久堵塞在一个等待进入的同步快的状态
 *  等待的线程永远不被唤醒
 *
 *  如何避免上述问题
 *   设置合理的优先级
 *   使用锁来代替synchronized
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Runnable target = new ThreadRunnable();
        Thread t1 = new Thread(target);
        Thread t2 = new Thread(target);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
