package com.etc.thread.t2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author:zrd
 * @Description:
 * @Date:2018-8-22 20:25
 */
public class CallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("正在进行线程方法的执行----");
        Thread.sleep(3000);
        return 1+1;
    }

    public static void main(String[] args)throws  Exception {
        CallableThread c1 = new CallableThread();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(c1);
        new Thread(futureTask).start();
        System.out.println("线程的返回值为"+futureTask.get());

    }
}
