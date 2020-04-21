package com.java.filter;

import java.util.Random;

public class ThreadLocal2 {
    // 定义一个保存值为Integer的ThreadLocal
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    // 方法
    public static void main(String[] args) {
        Thread th1 = new Thread(new MyTask2(threadLocal));
        Thread th2 = new Thread(new MyTask2(threadLocal));
        Thread th3 = new Thread(new MyTask2(threadLocal));
        th1.start();
        th2.start();
        th3.start();
    /*
打印结果:
Thread-0生成的随机数：248
Thread-2生成的随机数：271
Thread-1生成的随机数：287
Thread-2获取值：271
Thread-1获取值：287
Thread-0获取值：248
     */
    }

}

class MyTask2 implements Runnable{
    ThreadLocal<Integer> threadLocal;
    // 随机数对象
    private static Random random = new Random(System.currentTimeMillis());

    // 构造器
    public MyTask2(ThreadLocal<Integer>  threadLocal) {
        this.threadLocal = threadLocal;
    }

    @Override
    public void run() {
        // 生成一个随机数
        int num = random.nextInt(1000);
        System.out.println(Thread.currentThread().getName() + "生成的随机数：" + num);
        // 设置值
        threadLocal.set(num);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 取出值
        System.out.println(Thread.currentThread().getName() + "获取值：" + threadLocal.get());
    }
}
