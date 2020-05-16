package com.thintime.bigdataui.fragment;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Thintime
 * @create 2020/4/5
 * @desc todo 碎片化知识1：原子操作类，Java运算不具备原子性
 * @note 运行20个自增线程，count都是小于20000
 */
@Data
public class Atomic1 {
    public static final int THREAD_COUNT = 20;
    //public static int count = 0;
    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i1 = 0; i1 < 1000; i1++) {
                        //count++;
                        count.incrementAndGet();
                    }
                }
            });
            threads[i].start();
        }
        System.out.println(count);
    }
}
