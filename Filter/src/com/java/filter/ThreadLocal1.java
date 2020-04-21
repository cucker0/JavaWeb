package com.java.filter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 利用map来实现线程保存变量
 */
public class ThreadLocal1 {
    private static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Thread th1 = new Thread(new MyTask(map));
        Thread th2 = new Thread(new MyTask(map));
        th1.start();
        th2.start();
        /*
打印结果：
Thread-1生成的随机数：341
Thread-0生成的随机数：781
map[Thread-1]: 341
map[Thread-0]: 781

         */
    }
}

class MyTask implements Runnable {
    private static Random random = new Random(System.currentTimeMillis());
    Map<String, Integer> map;

    public MyTask(Map<String, Integer> map) {
        super();
        this.map = map;
    }

    @Override
    public void run() {
        int num = random.nextInt(1000);
        System.out.println(Thread.currentThread().getName() + "生成的随机数：" + num);
        map.put(Thread.currentThread().getName(), num);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 用线程名作key，取出值
        System.out.println("map[" + Thread.currentThread().getName() + "]: " + map.get(Thread.currentThread().getName()));
    }
}

